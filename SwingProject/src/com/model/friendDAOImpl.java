package com.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class friendDAOImpl implements friendDAO {
	String url;
	String user; 
	String pwd;
	
	// 생성자- db 연결
	public friendDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url	= "jdbc:oracle:thin:@localhost:1521:xe";
			user = "scott";
			pwd = "1234";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void friendInsert(friend f) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "INSERT INTO friend VALUES(firend_seq.nextval,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,f.getName());
			pstmt.setString(2, f.getBirth());
			pstmt.setString(3, f.getPhone());
			pstmt.setString(4, f.getAddr());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con,pstmt);
		}
	}

	private void closeConnection(Connection con, PreparedStatement pstmt) {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override	// 전체보기
	public ArrayList<friend> friendView() {
		Connection con	=	null;
		Statement st	=	null;
		ResultSet	rs	=	null;
		
		ArrayList<friend> array	= new ArrayList<friend>();
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM friend ORDER BY 1 DESC";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				friend f = new friend();
				
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				array.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con,st,rs);
		}
		return array;
	}

	private void closeConnection(Connection con, Statement st, ResultSet rs) {
		
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

	@Override
	public friend friendDetail(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void friendUpdate(friend f) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "UPDATE friend SET name = ?,birth =?,phone =?,addr=? WHERE num = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, f.getName());
			pstmt.setString(2, f.getBirth());
			pstmt.setString(3, f.getPhone());
			pstmt.setString(4, f.getAddr());
			pstmt.setInt(5, f.getNum());
			pstmt.executeUpdate();
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, pstmt);
		}
	}

	@Override
	public void friendDelete(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "DELETE FROM friend WHERE num ="+num;
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, pstmt);
		}
		
	}

	@Override
	public ArrayList<friend> friendSearch(String key, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<friend> array	= new ArrayList<friend>();
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM friend WHERE "+key+" like '%"+word+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				friend f = new friend();
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				f.setNum(rs.getInt("num"));
				array.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return array;
	}

}
