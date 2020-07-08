package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import com.friend.friend;
import com.friend.friendDAOImpl;

public class FriendTest {
	private String Drive = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user =  "scott";
	private String pw	= "1234";
	
	
	// DB연동 테스트
	@Test
	public void connectionTest() throws Exception {
		Class.forName(Drive);
		try(Connection con = DriverManager.getConnection(url, user, pw)){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	// 추가 테스트
/*	@Test
	public void insertTest() {
		friendDAOImpl dao = new friendDAOImpl();
		friend f = new friend();
		f.setAddr("부산 서면");
		f.setBirth("020202");
		f.setName("김애기");
		f.setPhone("010-010-010");
		f.setNum(1234);
		dao.friendInsert(f);
	}
*/	
	// 상세보기 테스트
/*	@Test
	public void detailTest() {
		friendDAOImpl dao = new friendDAOImpl();
		assertEquals("ddd", dao.friendDetail(7).getName()); 
	}
*/	
	
	// 수정 테스트
/*	@Test
	public void updateTest() {
		friendDAOImpl dao = new friendDAOImpl();
		friend f = new friend();
		f.setName("김똘똘");
		f.setBirth("1988.11.22");
		f.setNum(4);
		dao.friendUpdate(f);
	}
*/
	
	// 삭제 테스트
/*	@Test
	public void deleteTest() {
		friendDAOImpl dao = new friendDAOImpl();
		dao.friendDelete(5);
	}
*/	
	
}
