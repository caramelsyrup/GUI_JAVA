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
	// static���� �ν��ٽ��� ��ü ����.
	private static AddressDAO instance = new AddressDAO();
	// static���� instance�� ��ȯ�ϴ� �޼ҵ����.
	public static AddressDAO getInstance() {
		return instance;
	}
	// ��񿬰�, ��Ĺ�� �����ϴ� DBCP�� �̿�.
	// Class.forname�� ���� �ʴ´�. �������ӿ� ���� ���� ���� ���.
	// Severs ������Ʈ�� �ִ� context.xml������ �����Ͽ�, META-INF�� �־��ش�.
	// server.xml ������ �κп� ����, �� ������Ʈ�� �߰� �Ǵ� ���� �� �� �ְ�, ���⿡ ���̵� ��������� ���� ����.
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	// �߰� �޼ҵ�
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
	
	// ��ü����
	public ArrayList<Address> addressList() throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Address> address = new ArrayList<Address>();
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM address";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
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
		}
		return address;
	}
	
	//�󼼺���
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
	
	//�����ϱ�
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
	
	
	// �ݱ� �޼ҵ�1
	private void closeConnection(Connection con, PreparedStatement pstmt) {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	// �ݱ�޼ҵ�2
	private void closeConnection(Connection con, PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	// �ݱ�޼ҵ�3
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
