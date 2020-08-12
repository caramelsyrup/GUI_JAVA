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
	// ��ü ����
	static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	//���� 
	private Connection getconnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/board");
			return ds.getConnection();
	}
	// �ݱ�
	public void closeconnection(Connection con, PreparedStatement pstmt) {
			try {
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void closeconnection(Connection con, Statement st, ResultSet rs) {
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
	
	
	@Override	// ȸ�� �߰�
	public void memberInsert(MemberDTO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getconnection();
			String sql = "INSERT INTO member VALUES (member_seq.nextval,?,?,?,?,?,default,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,vo.getUserid());
			pstmt.setString(2, vo.getUserpwd());
			pstmt.setString(3, vo.getUseraddr());
			pstmt.setString(4, vo.getUsertel());
			pstmt.setString(5, vo.getUseremail());
			pstmt.setString(6, vo.getUserzipcode());
			pstmt.setString(7, vo.getUsername());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, pstmt);
		}
	}

	@Override
	public int memberUpdate(MemberDTO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override	// ȸ������ ����ȸ
	public MemberDTO memberDetail(String userID) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		MemberDTO member = new MemberDTO();;
		try {
			con = getconnection();
			String sql = "SELECT * FROM member WHERE userid ='"+userID+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				member.setAdmin(rs.getInt("admin"));
				member.setNum(rs.getInt("num"));
				member.setUseraddr(rs.getString("useraddr"));
				member.setUseremail(rs.getString("useremail"));
				member.setUserid(rs.getString("userid"));
				member.setUsername(rs.getString("username"));
				member.setUserpwd(rs.getString("userpwd"));
				member.setUsertel(rs.getString("usertel"));
				member.setUserzipcode(rs.getString("userzipcode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
		return member;
	}

	@Override
	public void memberDelete(String userID) {
		// TODO Auto-generated method stub
		
	}

	@Override	// id �ߺ�üũ
	public String idCheck(String userID) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		String flag = "yes";
		
		try {
			con = getconnection();
			String sql = "SELECT * FROM member WHERE userid = '"+userID+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				return "no";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			closeconnection(con, st, rs);
		}
		
		return flag;
	}

	@Override	// �α��� �Ǵ�
	public int loginCheck(String userID, String userPwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = getconnection();
			String sql = "SELECT userpwd,admin FROM member WHERE userid = '"+userID+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {	// id�� �����
				if(rs.getString("userpwd").equals(userPwd)) {
					int sign = rs.getInt("admin");
					// �Ϲ�ȸ�� 0, ��� ����Ʈ�� 0 ����. �����ڴ� 1
					
					return sign;	// �н����� �հ�
				}else {
					return 2;	// �н����� ����ġ
				}
			}else {
				return -1;	// id�� ����ġ
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
		return -2;	// db�� ����.
	}

	@Override
	public ArrayList<MemberDTO> memberList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override	// �ּҰ˻� �޼ҵ�
	public ArrayList<AddressDTO> addressSearch(String dong) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<AddressDTO> arr = new ArrayList<AddressDTO>();
		try {
			con = getconnection();
			String sql = "SELECT * FROM address WHERE dong LIKE '%"+dong+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AddressDTO address = new AddressDTO();
				address.setZipcode(rs.getString("zipcode"));
				address.setSido(rs.getString("sido"));
				address.setGugun(rs.getString("gugun"));
				address.setDong(rs.getString("dong"));
				address.setBunji(rs.getString("bunji"));
				arr.add(address);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
		return arr;
	}
	
}
