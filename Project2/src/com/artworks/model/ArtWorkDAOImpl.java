package com.artworks.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ArtWorkDAOImpl implements ArtWorkDAO {
	// 객체 생성
		static ArtWorkDAOImpl ainstance = new ArtWorkDAOImpl();
		public static ArtWorkDAOImpl getInstance() {
			return ainstance;
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
	
	@Override	// 작품전체보기
	public ArrayList<ArtWorkDTO> artworkList(int startRow, int endRow) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ArtWorkDTO> array = new ArrayList<ArtWorkDTO>();
		StringBuilder sb = new StringBuilder();
		try {
			con = getconnection();
			sb.append("SELECT * FROM ");
			sb.append("(SELECT aa.* , rownum rn FROM ");
			sb.append("(SELECT * FROM artworks ORDER BY artid DESC) aa ");
			sb.append("WHERE rownum<="+endRow+") WHERE rn>="+startRow);
			st = con.createStatement();
			rs = st.executeQuery(sb.toString());
		
			while(rs.next()) {
				ArtWorkDTO art = new ArtWorkDTO();
				art.setArtdescription(rs.getString("artdescription"));
				art.setArtid(rs.getInt("artid"));
				art.setArtmaker(rs.getString("artmaker"));
				art.setArttitle(rs.getString("arttitle"));
				art.setFilename(rs.getString("filename"));
				array.add(art);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
		return array;
	}

	@Override	// 작품추가
	public void artworkInsert(ArtWorkDTO art) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getconnection();
			String sql = "INSERT INTO artworks VALUES (artworks_seq.nextval,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, art.getArttitle());
			pstmt.setString(2, art.getArtmaker());
			pstmt.setString(3, art.getArtdescription());
			pstmt.setString(4, art.getFilename());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, pstmt);
		}
	}
	@Override	// 작품상세보기
	public ArtWorkDTO artworkDetail(int artid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArtWorkDTO art = null;
		
		try {
			con = getconnection();
			st = con.createStatement();
			String sql = "SELECT * FROM artworks WHERE artid="+artid;
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				art = new ArtWorkDTO();
				art.setArtdescription(rs.getString("artdescription"));
				art.setArtid(rs.getInt("artid"));
				art.setArtmaker(rs.getString("artmaker"));
				art.setArttitle(rs.getString("arttitle"));
				art.setFilename(rs.getString("filename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
		return art;
	}
	
	@Override	// 작품 삭제하기
	public void artworkDelete(int artid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = getconnection();
			st = con.createStatement();
			String sql = "DELETE FROM artworks WHERE artid="+artid;
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				con.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
	}
	@Override
	public int artworkCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
