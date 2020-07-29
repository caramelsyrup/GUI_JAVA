package org.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SAddressDAO {
	//객체생성
	private static SAddressDAO instance = new SAddressDAO();
	public static SAddressDAO getinstance() {
		return instance;
	}
	
	//연결메소드
	private Connection getConnection()throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	// 닫기 메소드
	public void closeConnection(Connection con, Statement st, ResultSet rs) {
			try {
				if(rs!=null)	rs.close();
				if(st!=null)	st.close();
				if(con!=null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void closeConnection(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null)	pstmt.close();
			if(con!=null)	con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//추가메소드
	public void insertAddress(SAddressDTO sa) {
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "INSERT INTO address(num,address,name,tel,zipcode) VALUES(address_seq.nextval,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sa.getAddress());
			pstmt.setString(2, sa.getName());
			pstmt.setString(3, sa.getTel());
			pstmt.setString(4, sa.getZipcode());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, pstmt);
		}
	}
	
	// 전체보기 메소드
	public ArrayList<SAddressDTO> addressList(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<SAddressDTO> arr = new ArrayList<SAddressDTO>();
		try {
			con = getConnection();
			String sql = "SELECT * FROM address";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				SAddressDTO sa = new SAddressDTO();
				sa.setNum(rs.getInt("num"));
				sa.setAddress(rs.getString("address"));
				sa.setName(rs.getString("name"));
				sa.setTel(rs.getString("tel"));
				sa.setZipcode(rs.getString("zipcode"));
				arr.add(sa);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		
		return arr;
	}
	
	// 상세보기 메소드
	public SAddressDTO addressDetail(int num){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		SAddressDTO sa = null;;
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM address WHERE num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				sa = new SAddressDTO();
				sa.setAddress(rs.getString("address"));
				sa.setName(rs.getString("name"));
				sa.setNum(rs.getInt("num"));
				sa.setTel(rs.getString("tel"));
				sa.setZipcode(rs.getString("zipcode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return sa;
	}
	
	// 삭제하기 메소드
	public void addressDelete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			String sql = "DELETE FROM address WHERE num="+num;
			st = con.createStatement();
			st.executeUpdate(sql);
			
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, null);
		}
	}
	
	//수정하기 메소드
	public void addressUpdate(SAddressDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "UPDATE address SET address=? , name=? , zipcode=? , tel=? WHERE num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getAddress());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getZipcode());
			pstmt.setString(4, dto.getTel());
			pstmt.setInt(5, dto.getNum());
			pstmt.executeUpdate();
			
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, pstmt);
		}
	}
	
	// 개수 세기 메소드
	public int addressCount() {
		int count = 0;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "SELECT COUNT(num) FROM address";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next())
			count = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return count;
	}
	
	//우편번호 검색
	public ArrayList<ZipcodeDTO> zipSearch(String dong) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipcodeDTO> arr = new ArrayList<ZipcodeDTO>();
		try {
			con = getConnection();
			String sql = "SELECT * FROM zipcode WHERE dong LIKE '%"+dong+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ZipcodeDTO zip = new ZipcodeDTO();
				zip.setBunji(rs.getString("bunji"));
				zip.setDong(rs.getString("dong"));
				zip.setGugun(rs.getString("gugun"));
				zip.setSido(rs.getString("sido"));
				zip.setZipcode(rs.getString("zipcode"));
				arr.add(zip);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return arr;
	}
	
	// 전체 중 주소 검색
	public ArrayList<SAddressDTO> addressSearch(String field, String word ){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		ArrayList<SAddressDTO> arr = new ArrayList<SAddressDTO>();
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM address WHERE "+field+" LIKE '%"+word+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				SAddressDTO dto = new SAddressDTO();
				dto.setAddress(rs.getString("address"));
				dto.setName(rs.getString("name"));
				dto.setNum(rs.getInt("num"));
				dto.setTel(rs.getString("tel"));
				dto.setZipcode(rs.getString("zipcode"));
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return arr;
	}
	
	public int searchCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = getConnection();
			String sql = "SELECT COUNT(num) FROM address WHERE "+field+" LIKE '%"+word+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
}
