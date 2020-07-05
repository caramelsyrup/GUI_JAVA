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
    		/* step1. db 설정 */
			Class.forName("oracle.jdbc.driver.OracleDriver");		// 오라클드라이버 로드	
		    member m = memberMap.get(MemberKey);
			       /*
			        * memberMap에 로그인된 유저 정보가 들어있고, 유저 계정이름이 동일한 경우 db member table 에 접근하지 않음.
			        */
			       if (memberMap.get(MemberKey) != null) {
			    	   if (m.getAccount().equals(id) && m.getPassword() == pw) {
			          System.out.println(id + " Already Exit Login! ");
			          return true;
			      }
			      System.out.println("Incorret User Info > id: " + id + ", pw:" + pw);
			      return false;
			       }
			       /* step1. db 설정 */
			     // 오라클드라이버 로드
			       con = DriverManager.getConnection(url, user, pwd); // db 연결하고, scott계정 db선택.

			       /* step2. db 조회 */
			       sql = "SELECT * FROM member WHERE account ='"+id+"'"+"and password = "+pw + " AND ROWNUM = 1";
			       st = con.createStatement();
			       rs = st.executeQuery(sql); // id를 입력하여 db에 있으면 테이블 자료를 가져옴.

			       /* step3. 조회된 결과 맵에 담기 */
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
			       System.out.println("문제있음");
			       e1.printStackTrace();
			   } catch (ClassNotFoundException e) {
			       e.printStackTrace();
			   } catch (NumberFormatException e3) {
			       JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
			   } finally {
			       closeConnection(con, st, rs);
			   }
			   return false;
    	}
}
	
	

		

   
