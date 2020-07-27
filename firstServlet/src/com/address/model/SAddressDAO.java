package com.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			
		}
	}
	// 전체보기
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
		}
		
		return arr;
	}
}
