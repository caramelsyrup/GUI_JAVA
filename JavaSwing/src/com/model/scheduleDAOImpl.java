package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class scheduleDAOImpl implements scheduleDAO {
	
	String url,user,pwd;
	// �����ڴ� ���� ����
	public scheduleDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url	= "jdbc:oracle:thin:@localhost:1521:xe";
			user = "scott";
			pwd = "1234";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// ����ݱ� �޼ҵ�
		private void closeConnection(PreparedStatement pstmt, Connection con) {
				try {
					if(pstmt != null)
						pstmt.close();
					if(con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		private void closeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	@Override	// ��ü����
	public ArrayList<schedule> scheduleView() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		ArrayList<schedule> arr = new ArrayList<schedule>();
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT airline,dep,arr,year,month FROM schedule";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				schedule sch = new schedule();
				sch.setAirline(rs.getString("airline"));
				sch.setDep((rs.getString("dep")));
				sch.setArr((rs.getString("arr")));
				sch.setYear((rs.getInt("year")));
				sch.setMonth((rs.getInt("month")));
				arr.add(sch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return arr ;
	}

	@Override	// ����ȸ
	public schedule scheduleDetail(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override	// ����� �˻����
	public ArrayList<schedule> departureSearch(String key ,String word) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<schedule> arr = new ArrayList<schedule>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM schedule WHERE dep = '"+word+"'"; 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				schedule sch = new schedule();
				sch.setAirline((rs.getString("airline")));
				sch.setDep((rs.getString("dep")));
				sch.setArr((rs.getString("arr")));
				sch.setYear((Integer.parseInt(rs.getString("year"))));
				sch.setMonth((Integer.parseInt(rs.getString("month"))));
				arr.add(sch);
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
		return arr;
	}
	@Override	// ������ �˻�
	public ArrayList<schedule> arriveSearch(String arrive, String word) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<schedule> arr = new ArrayList<schedule>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM schedule WHERE arr = '"+word+"'"; 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				schedule sch = new schedule();
				sch.setAirline((rs.getString("airline")));
				sch.setDep((rs.getString("dep")));
				sch.setArr((rs.getString("arr")));
				sch.setYear((Integer.parseInt(rs.getString("year"))));
				sch.setMonth((Integer.parseInt(rs.getString("month"))));
				arr.add(sch);
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
		return arr;
	}
	@Override	// �� �˻�
	public ArrayList<schedule> schSearch(String yea, int word) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<schedule> arr = new ArrayList<schedule>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM schedule WHERE "+yea+"= '"+word+"'"; 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				schedule sch = new schedule();
				sch.setAirline((rs.getString("airline")));
				sch.setDep((rs.getString("dep")));
				sch.setArr((rs.getString("arr")));
				sch.setYear((Integer.parseInt(rs.getString("year"))));
				sch.setMonth((Integer.parseInt(rs.getString("month"))));
				arr.add(sch);
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
		return arr;
	}
}