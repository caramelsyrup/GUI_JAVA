package com.events.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.member.model.MemberDTO;

public class EventsDAOImpl implements EventsDAO {
		// 객체 생성
		static EventsDAOImpl instance = new EventsDAOImpl();
		public static EventsDAOImpl getInstance() {
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

	@Override	// 행사추가하기
	public void eventsInsert(EventsDTO event) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getconnection();
			String sql = "INSERT INTO events VALUES(events_seq.nextval,?,?,TO_DATE(?,'YY-MM-DD HH24:MI'),?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, event.getEventname());
			pstmt.setString(2, event.getEventhost());
			pstmt.setString(3, event.getEventsche());
			pstmt.setString(4, event.getEventlocation());
			pstmt.setString(5, event.getEventdescip());
			pstmt.setString(6, event.getFilename());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			closeconnection(con, pstmt);
		}
	}

	@Override	// 행사 전체 보기
	public ArrayList<EventsDTO> eventsList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<EventsDTO> arr = new ArrayList<EventsDTO>();
		try {
			con = getconnection();
			st = con.createStatement();
			String sql = "SELECT eventnum,eventname,eventhost,eventsche,eventlocation,eventdescip,filename FROM events ORDER BY eventnum DESC";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				EventsDTO dto = new EventsDTO();
				dto.setEventdescip(rs.getString("eventdescip"));
				dto.setEventhost(rs.getString("eventhost"));
				dto.setEventlocation(rs.getString("eventlocation"));
				dto.setEventname(rs.getString("eventname"));
				dto.setEventnum(rs.getInt("eventnum"));
				dto.setEventsche(rs.getString("eventsche"));
				dto.setFilename(rs.getString("filename"));
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
		return arr;
	}
	@Override // 행사 상세 보기
	public EventsDTO eventsDetail(int eventnum) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		EventsDTO event = new EventsDTO();
		try {
			con = getconnection();
			String sql = "SELECT * FROM events WHERE eventnum ="+eventnum;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				event.setEventdescip(rs.getString("eventdescip"));
				event.setEventhost(rs.getString("eventhost"));
				event.setEventlocation(rs.getString("eventlocation"));
				event.setEventname(rs.getString("eventname"));
				event.setEventnum(rs.getInt("eventnum"));
				event.setEventsche(rs.getString("eventsche"));
				event.setFilename(rs.getString("filename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeconnection(con, st, rs);
		}
		return event;
	}

}
