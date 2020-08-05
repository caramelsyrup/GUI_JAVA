package com.guest.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GuestDAO {
	//디비셋팅
	private static GuestDAO instance = new GuestDAO();
	public static GuestDAO getinstance() {
		return instance;
	}
	
	private Connection getConnection()throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/guest");
		return ds.getConnection();
	}
	// 연결 닫기
	public void closeConnection(Connection con, PreparedStatement pstmt) {
			try {
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void closeConnection(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs!=null)
				rs.close();
			if(st!=null)
				st.close();
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 추가
	public void guestInsert(GuestDTO guest) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "INSERT INTO guestbook VALUES (guestbook_seq.nextval,?,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, guest.getWritter());
			pstmt.setString(2, guest.getContent());
			pstmt.setString(3, guest.getGrade());
			pstmt.setString(4, guest.getIpaddr());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, pstmt);
		}
	}
	
	// 전체 보기
	public ArrayList<GuestDTO>guestList(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<GuestDTO>arr = new ArrayList<GuestDTO>();
		try {
			con = getConnection();
			String sql = "SELECT * FROM guestbook ORDER BY num DESC";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				GuestDTO guest = new GuestDTO();
				guest.setNum(rs.getInt("num"));
				guest.setWritter(rs.getString("writter"));
				guest.setContent(rs.getString("content"));
				guest.setGrade(rs.getString("grade"));
				guest.setCreated(rs.getString("created"));
				guest.setIpaddr(rs.getString("ipaddr"));
				arr.add(guest);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return arr;
	}
	// 수 세기
	public int guestCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con = getConnection();
			String sql = "SELECT COUNT(num) FROM guestbook";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return count;
	}
	
	// 전체보기 페이징
	public ArrayList<GuestDTO> guestList(int startRow, int endRow) {
		Connection con = null;
		Statement st = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GuestDTO> arr = new ArrayList<GuestDTO>();
		
		try {
			con = getConnection();

			StringBuilder sb = new StringBuilder();
			sb.append("select * from");
			sb.append(" (select aa.*, rownum rn from");
			sb.append(" (select * from guestbook order by num desc) aa");
			sb.append(" where rownum<=? ) where rn>=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GuestDTO guest = new GuestDTO();
				guest.setNum(rs.getInt("num"));
				guest.setWritter(rs.getString("writter"));
				guest.setContent(rs.getString("content"));
				guest.setGrade(rs.getString("grade"));
				guest.setCreated(rs.getString("created"));
				guest.setIpaddr(rs.getString("ipaddr"));
				arr.add(guest);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return arr;
	}
	
	// 상세보기
	public ArrayList<GuestDTO> guestView(int num){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<GuestDTO> arr = new ArrayList<GuestDTO>();
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM guestbook WEHRE num ="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				GuestDTO guest = new GuestDTO();
				guest.setNum(rs.getInt("num"));
				guest.setWritter(rs.getString("writter"));
				guest.setContent(rs.getString("content"));
				guest.setGrade(rs.getString("grade"));
				guest.setCreated(rs.getString("created"));
				guest.setIpaddr(rs.getString("ipaddr"));
				arr.add(guest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return arr;
	}
	
	
	
}
