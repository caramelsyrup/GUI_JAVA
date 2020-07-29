package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAOImpl implements MemberDAO {
	
	// ��ü ���� �޼ҵ�
	private static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getinstance() {
		return instance;
	}
	
	private Connection getConnection()throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/member");
		return ds.getConnection();
	}
	
	// ���� �ݱ� �޼ҵ�
	public void closeConnection(Connection con,PreparedStatement pstmt) {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void closeConnection(Connection con,Statement st,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ȸ�� ���� �޼ҵ�
	@Override
	public void memberInsert(MemberDTO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "INSERT INTO member VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserName());
			pstmt.setString(3, vo.getUserPwd());
			pstmt.setString(4, vo.getUserEmail());
			pstmt.setString(5, vo.getUserTel());
			pstmt.setInt(6, vo.getAdmin());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, pstmt);
		}
	}
	
	// ��� ��� ���� �޼ҵ�
	@Override
	public ArrayList<MemberDTO> memberList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ��� ���� ���� �޼ҵ�
	@Override
	public int memberUpdate(MemberDTO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// ��� ���� �� ���� �޼ҵ�
	@Override
	public MemberDTO memberDetail(String userID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ��� ���� �޼ҵ�
	@Override
	public void memberDelete(String userID) {
		// TODO Auto-generated method stub
		
	}
	
	// id�ߺ� üũ �޼ҵ�
	@Override
	public String idCheck(String userID) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		String flag = "yes";
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM member WHERE userID ='"+userID+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			// id�� ������ ���� ��ȸ�� �Ǳ� ������, no�� ��ȯ�Ͽ� ���̵� ������ �������Ѵ�.
			if(rs.next()) {
				return flag = "no";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return flag;
	}
	
	// �α��� �Ǵ� �޼ҵ�
	@Override
	public int loginCheck(String userID, String userPwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "SELECT userPwd, admin FROM member WHERE userID = '"+userID+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				if(rs.getString("userPwd").equals(userPwd)) {	// String�� �񱳴� equals
					int flag = rs.getInt("admin");	// DB�� 0�Ǵ� 1�� ������ �Ǿ� ����.
					return flag;
				}else {
					return 2;	// userID�� ������ userPwd ����ġ.
				}
			}else {
				return -1;	// rs��  ���� . userID�� ����.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return -2;	// DB����
	}
	
	// ���Ե� ��� ���� ���� �޼ҵ�
	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
