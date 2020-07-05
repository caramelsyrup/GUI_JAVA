package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class reservationDAOImpl implements reservationDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String url,user,pwd;
	public static final Map<String, schedule> scheduleMap = new HashMap<String, schedule>();
	public reservationDAOImpl() {
		// 생성자는 서버 연결
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				url	= "jdbc:oracle:thin:@localhost:1521:xe";
				user = "scott";
				pwd = "1234";
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			 con = null;
			 pstmt = null;
			 rs = null;
			
			try {
				con = DriverManager.getConnection(url, user, pwd);
				String sql = "SELECT airline,dep,arr,year,month FROM schedule"; 
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(sql);
				
				while(rs.next()) {
					schedule s = new schedule();
					s.setAirline(rs.getString("airline"));
					s.setDep(rs.getString("dep"));
					s.setArr(rs.getString("arr"));
					s.setYear(rs.getInt("year"));
					s.setMonth(rs.getInt("month"));
					scheduleMap.put(rs.getString("airline"), s);
				}
//				System.out.println(scheduleMap.get("KOREAN_AIR").getAirline());
//				System.out.println(LoginTest.memberMap.get(LoginTest.MemberKey).getName());
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(con, pstmt, rs);
			}
	}
	
	// 연결닫기 메소드
	private void closeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  void KreservationInsert() {
		con = null;
		pstmt = null;
		
		 try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "INSERT INTO reservation(account,name,airline,dep,arr,year,month) VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
	    	pstmt.setString(1,LoginTest.memberMap.get(LoginTest.MemberKey).getAccount());
			pstmt.setString(2, LoginTest.memberMap.get(LoginTest.MemberKey).getName());
			pstmt.setString(3, scheduleMap.get("KOREAN_AIR").getAirline());
			pstmt.setString(4,scheduleMap.get("KOREAN_AIR").getDep());
			pstmt.setString(5, scheduleMap.get("KOREAN_AIR").getArr());
			pstmt.setInt(6, scheduleMap.get("KOREAN_AIR").getYear());
			pstmt.setInt(7,scheduleMap.get("KOREAN_AIR").getMonth());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "예약이 되었습니다.");
			con.commit();
		} catch(SQLIntegrityConstraintViolationException e1) {
			e1.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, pstmt, rs);
		}
	}

	@Override
	public void AreservationInsert() {
		con = null;
		pstmt = null;
		
		 try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "INSERT INTO reservation(account,name,airline,dep,arr,year,month) VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
	    	pstmt.setString(1,LoginTest.memberMap.get(LoginTest.MemberKey).getAccount());
			pstmt.setString(2, LoginTest.memberMap.get(LoginTest.MemberKey).getName());
			pstmt.setString(3, scheduleMap.get("ASIAN_AIR").getAirline());
			pstmt.setString(4,scheduleMap.get("ASIAN_AIR").getDep());
			pstmt.setString(5, scheduleMap.get("ASIAN_AIR").getArr());
			pstmt.setInt(6, scheduleMap.get("ASIAN_AIR").getYear());
			pstmt.setInt(7,scheduleMap.get("ASIAN_AIR").getMonth());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "예약이 되었습니다.");
			con.commit();
		} catch(SQLIntegrityConstraintViolationException e1) {
			e1.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, pstmt, rs);
		}
	}

	@Override
	public void BreservationInsert() {
		con = null;
		pstmt = null;
		
		 try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "INSERT INTO reservation(account,name,airline,dep,arr,year,month) VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
	    	pstmt.setString(1,LoginTest.memberMap.get(LoginTest.MemberKey).getAccount());
			pstmt.setString(2, LoginTest.memberMap.get(LoginTest.MemberKey).getName());
			pstmt.setString(3, scheduleMap.get("BUSAN_AIR").getAirline());
			pstmt.setString(4,scheduleMap.get("BUSAN_AIR").getDep());
			pstmt.setString(5, scheduleMap.get("BUSAN_AIR").getArr());
			pstmt.setInt(6, scheduleMap.get("BUSAN_AIR").getYear());
			pstmt.setInt(7,scheduleMap.get("BUSAN_AIR").getMonth());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "예약이 되었습니다.");
			con.commit();
		} catch(SQLIntegrityConstraintViolationException e1) {
			e1.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, pstmt, rs);
		}
		
	}

}
