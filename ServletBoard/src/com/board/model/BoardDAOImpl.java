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
	
	//접속 
	private Connection getconnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/board");
			return ds.getConnection();
	}
	// 닫기
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
	@Override	// 추가
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

	@Override	// 전체보기
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
	

	@Override	// 상세보기
	public BoardDTO boardfindById(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BoardDTO dto = null;
		
		try {
			con = getconnection();
			st = con.createStatement();
			String sql = "SELECT * FROM TBL_BOARD WHERE num="+num;
			rs = st.executeQuery(sql);
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setContent(rs.getString("content"));
				dto.setNum(rs.getInt("num"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setSubject(rs.getString("subject"));
				dto.setWritter(rs.getString("writter"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
		return dto;
	}

	@Override
	public void boardUpdate(BoardDTO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardDelete(int num) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override	// 전체 글 개수 세기.
	public int boardCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = getconnection();
			st = con.createStatement();
			String sql = "SELECT COUNT(num) FROM TBL_BOARD";
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
		return count;
	}

	@Override	// 전체 보기 페이징
	public ArrayList<BoardDTO> boardList(int startRow, int endRow) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> arr = new ArrayList<BoardDTO>();
		
		try {
			con = getconnection();
			StringBuilder sb = new StringBuilder();
					sb.append("SELECT * FROM ");
					sb.append(" (SELECT aa.* , rownum rn FROM (");
					sb.append("SELECT * FROM TBL_BOARD ORDER BY num DESC) aa ");
					sb.append("WHERE rownum<="+endRow+") WHERE rn >="+startRow);
			st = con.createStatement();
			rs = st.executeQuery(sb.toString());
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setContent(rs.getString("content"));
				board.setNum(rs.getInt("num"));
				board.setReadcount(rs.getInt("readcount"));
				board.setReg_date(rs.getString("reg_date"));
				board.setSubject(rs.getString("subject"));
				board.setWritter(rs.getString("writter"));
				arr.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeconnection(con, st, rs);
		}
		return arr;
	}

	@Override	// 댓글 쓰기 기능
	public void commentInsert(CommentDTO comment) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getconnection();
			String sql = "INSERT INTO commenttable(cnum,userid,msg,regdate,bnum) VALUES (commenttable_seq.nextval,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, comment.getUserid());
			pstmt.setString(2, comment.getMsg());
			pstmt.setInt(3, comment.getBnum());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, pstmt);
		}
		
	}

	@Override	// 댓글 전체보기
	public ArrayList<CommentDTO> commentList(int bnum) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<CommentDTO>arr=new ArrayList<CommentDTO>();
		try {
			con = getconnection();
			st = con.createStatement();
			String sql = "SELECT * FROM commenttable WHERE bnum ="+bnum;
			rs = st.executeQuery(sql);
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setBnum(rs.getInt("bnum"));
				dto.setCnum(rs.getInt("cnum"));
				dto.setMsg(rs.getString("msg"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setUserid(rs.getString("userid"));
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
		return arr;
	}

	
	
}
