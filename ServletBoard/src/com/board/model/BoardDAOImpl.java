package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAOImpl implements BoardDAO {
	
	private static BoardDAOImpl instance = new BoardDAOImpl();
	public static BoardDAOImpl getinstance() {
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
	@Override	// �߰�
	public void boardSave(BoardDTO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getconnection();
			String sql = "INSERT INTO TBL_BOARD VALUES (TBL_BOARD_SEQ.nextval,?,?,?,sysdate,1)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWritter());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getSubject());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, pstmt);
		}
	}

	@Override	// ��ü����
	public ArrayList<BoardDTO> boardList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BoardDTO dto = null;
		ArrayList<BoardDTO> arr = new ArrayList<BoardDTO>();
		try {
			con = getconnection();
			st = con.createStatement();
			String sql = "SELECT * FROM TBL_BOARD ORDER BY num DESC";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setWritter(rs.getString("writter"));
				dto.setContent(rs.getString("content"));
				dto.setSubject(rs.getString("subject"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setReadcount(rs.getInt("readcount"));
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
		return arr;
	}

	@Override	// �󼼺���
	public BoardDTO boardfindById(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardUpdate(BoardDTO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardDelete(int num) {
		// TODO Auto-generated method stub
		
	}

}
