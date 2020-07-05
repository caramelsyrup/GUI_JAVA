package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.view.allowView;
import com.view.view;

public class LoginTest {
	 	public static final String MemberKey = "member";
	    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    private String user = "scott";
	    private String pwd = "1234";
	    Connection con = null;
	    ResultSet rs = null;
	    Statement st = null;
	    String sql = null;
	    public static final Map<String, member> memberMap = new HashMap<String, member>();
    
    private void closeConnection(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    public  boolean accessLogin(String id,int pw) {
    	try {
    		/* step1. db ���� */
			Class.forName("oracle.jdbc.driver.OracleDriver");		// ����Ŭ����̹� �ε�	
		    member m = memberMap.get(MemberKey);
			       /*
			        * memberMap�� �α��ε� ���� ������ ����ְ�, ���� �����̸��� ������ ��� db member table �� �������� ����.
			        */
			       if (memberMap.get(MemberKey) != null) {
			    	   if (m.getAccount().equals(id) && m.getPassword() == pw) {
			          System.out.println(id + " Already Exit Login! ");
			          return true;
			      }
			      System.out.println("Incorret User Info > id: " + id + ", pw:" + pw);
			      return false;
			       }
			       /* step1. db ���� */
			     // ����Ŭ����̹� �ε�
			       con = DriverManager.getConnection(url, user, pwd); // db �����ϰ�, scott���� db����.

			       /* step2. db ��ȸ */
			       sql = "SELECT * FROM member WHERE account ='"+id+"'"+"and password = "+pw + " AND ROWNUM = 1";
			       st = con.createStatement();
			       rs = st.executeQuery(sql); // id�� �Է��Ͽ� db�� ������ ���̺� �ڷḦ ������.

			       /* step3. ��ȸ�� ��� �ʿ� ��� */
			      while (rs.next()) {
			      m = new member();
			      m.setAccount(rs.getString("account"));
			      m.setPassword(Integer.parseInt(rs.getString("password")));
			      m.setName(rs.getString("name"));
			      m.setBirth(rs.getString("birth"));
			      m.setPhone(rs.getString("phone"));
			      m.setCity(rs.getString("city"));
			      m.setEmail(rs.getString("email"));
			      memberMap.put(MemberKey, m);

			      return true;
			       }
			   } catch (SQLException e1) {
			       System.out.println("��������");
			       e1.printStackTrace();
			   } catch (ClassNotFoundException e) {
			       e.printStackTrace();
			   } catch (NumberFormatException e3) {
			       JOptionPane.showMessageDialog(null, "�߸� �Է��ϼ̽��ϴ�.");
			   } finally {
			       closeConnection(con, st, rs);
			   }
			   return false;
    	}
}
	
	

		

   
