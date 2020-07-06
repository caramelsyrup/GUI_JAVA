package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class ConnectionTest {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "scott";
	private static final String PW = "1234";
	
	// library �߰� - properties ���� java build path ���� library �ǿ��� �ش� ���̺귯���� Ŭ���Ͽ�, apply.
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
