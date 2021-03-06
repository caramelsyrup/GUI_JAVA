package com.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AddressDAO {
	// static으로 인스텐스로 객체 생성.
	private static final AddressDAO instance = new AddressDAO();
	// static으로 instance를 반환하는 메소드생성.
	public static AddressDAO getInstance() {
		return instance;
	}
	// 디비연결, 톰캣이 제공하는 DBCP를 이용.
	// Class.forname은 쓰지 않는다. 다중접속에 의한 서버 부하 우려.
	// Severs 프로젝트에 있는 context.xml파일을 복사하여, META-INF에 넣어준다.
	// server.xml 마지막 부분에 보면, 현 프로젝트가 추가 되는 것을 볼 수 있고, 여기에 아이디 비번등으로 접속 가능.
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	// 추가 메소드
	public void addressInsert(Address ad) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=getConnection();
			String sql = "INSERT INTO address VALUES(address_seq.nextval,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ad.getName());
			pstmt.setString(2, ad.getZipcode());
			pstmt.setString(3, ad.getAddress());
			pstmt.setString(4, ad.getTel());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con,pstmt);
		}
	}
	
	// 전체보기
	public ArrayList<Address> addressList(String field, String word) throws Exception{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Address> address = new ArrayList<Address>();
		String sql = "";
		try {
			con = getConnection();
			if(word.equals("")) {	// 검색이 비워져있을떄
				sql = "SELECT * FROM address ORDER BY 1";
			}else {					// 검색어를 넣었을떄
				sql = "SELECT * FROM address WHERE "+field+" like '%"+word+"%' ORDER BY 1";
			}
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Address ad = new Address();
				ad.setNum(rs.getLong("num"));
				ad.setName(rs.getString("name"));
				ad.setZipcode(rs.getString("zipcode"));
				ad.setAddress(rs.getString("address"));
				ad.setTel(rs.getString("tel"));
				address.add(ad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return address;
	}
	
	//상세보기
	public Address addressDetail(int num){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Address ad = null;
		try {
			con = getConnection();
			String sql = "SELECT * FROM address WHERE num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				ad = new Address();
				ad.setName(rs.getString("name"));
				ad.setZipcode(rs.getString("zipcode"));
				ad.setAddress(rs.getString("address"));
				ad.setTel(rs.getString("tel"));
				ad.setNum(rs.getLong("num"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return ad;
	}
	
	//수정하기
	public void addressUpdate(Address ad) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "UPDATE address SET name=?,zipcode=?,address=?,tel=? WHERE num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, ad.getName());
			pstmt.setString(2, ad.getZipcode());
			pstmt.setString(3, ad.getAddress());
			pstmt.setString(4, ad.getTel());
			pstmt.setLong(5, ad.getNum());
			pstmt.executeUpdate();
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, pstmt);
		}
	}
	
	//삭제하기
	public void addressDelete(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "DELETE FROM address WHERE num="+num;
//			String sql = "DELETE FROM address WHERE num= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(sql);
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, pstmt);
		}
	}
	
	// 우편번호 검색
	public ArrayList<ZipcodeBean> zipcodeRead(String dong) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipcodeBean> zipArr = new ArrayList<ZipcodeBean>();
		try {
			con = getConnection();
			String sql="SELECT * FROM zipcode WHERE dong LIKE '%"+dong+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ZipcodeBean zip = new ZipcodeBean();
				zip.setZipcode(rs.getString("zipcode"));
				zip.setSido(rs.getString("sido"));
				zip.setGugun(rs.getString("gugun"));
				zip.setDong(rs.getString("dong"));
				zip.setBunji(rs.getString("bunji"));
				zip.setSeq(rs.getInt("seq"));
				zipArr.add(zip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return zipArr;
	}
	
	// 갯수 세기
	public int getCount(String field, String word) {
		Connection con = null;
		Statement st  = null;
		ResultSet rs = null;
		String sql ="";
		int a = 0;
		
		try {
			con = getConnection();
			if(word.equals("")) {	// 검색 안댐.
				sql = "SELECT count(name) FROM address";
			}else {					// 검색이 댐
				sql = "SELECT count(name) cnt FROM address WHERE "+field+" LIKE '%"+word+"%'";
			}
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
			a = rs.getInt(1);
//			a = rs.getInt("cnt") 식으로 열의 별칭을 적어도 가능.			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return a;
	}
	
	// 닫기 메소드1
	private void closeConnection(Connection con, PreparedStatement pstmt) {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	// 닫기메소드2
	private void closeConnection(Connection con, PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	// 닫기메소드3
		private void closeConnection(Connection con, Statement st,ResultSet rs) {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
}
