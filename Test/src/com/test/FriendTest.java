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
	
	
	// DB���� �׽�Ʈ
	@Test
	public void connectionTest() throws Exception {
		Class.forName(Drive);
		try(Connection con = DriverManager.getConnection(url, user, pw)){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	// �߰� �׽�Ʈ
/*	@Test
	public void insertTest() {
		friendDAOImpl dao = new friendDAOImpl();
		friend f = new friend();
		f.setAddr("�λ� ����");
		f.setBirth("020202");
		f.setName("��ֱ�");
		f.setPhone("010-010-010");
		f.setNum(1234);
		dao.friendInsert(f);
	}
*/	
	// �󼼺��� �׽�Ʈ
/*	@Test
	public void detailTest() {
		friendDAOImpl dao = new friendDAOImpl();
		assertEquals("ddd", dao.friendDetail(7).getName()); 
	}
*/	
	
	// ���� �׽�Ʈ
/*	@Test
	public void updateTest() {
		friendDAOImpl dao = new friendDAOImpl();
		friend f = new friend();
		f.setName("��ʶ�");
		f.setBirth("1988.11.22");
		f.setNum(4);
		dao.friendUpdate(f);
	}
*/
	
	// ���� �׽�Ʈ
/*	@Test
	public void deleteTest() {
		friendDAOImpl dao = new friendDAOImpl();
		dao.friendDelete(5);
	}
*/	
	
}
