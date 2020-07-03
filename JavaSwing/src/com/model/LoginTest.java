package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.view.allowView;
import com.view.view;

public class LoginTest {
	
	String id;
	int pw;
	
    Connection con = null;
    ResultSet rs = null;
    Statement st = null;
    String sql = null;
    ArrayList<member> arr = new ArrayList<member>();
    view v = new view();
    allowView frame = new allowView();
    
    public LoginTest(String id,int pw) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 오라클드라이버 로드	
			String url	= "jdbc:oracle:thin:@localhost:1521:xe"; 
			String user = "scott";
			String pwd = "1234";
			con = DriverManager.getConnection(url, user, pwd);	// db 연결하고, scott계정 db선택.
			
			sql = "SELECT * FROM member WHERE account ='"+id+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);	// id를 입력하여 db에 있으면 테이블 자료를 가져옴.
			
			if(rs.next() == false || id.isEmpty() == true) {	// id가 없을때.
				JOptionPane.showMessageDialog(null, "ACCOUNT를 확인하세요");
			} else {
				sql = "SELECT * FROM member WHERE account = '"+id+"'";
				rs = st.executeQuery(sql);
				while (rs.next() == true) {
                    if (Integer.parseInt(rs.getString(3)) == pw) {	// db의 password와 pw와 같은지 비교
                    	JOptionPane.showMessageDialog(null, "로그인성공");
    					frame.setVisible(true);
    					v.setVisible(false);
                    } else {                
                    	JOptionPane.showMessageDialog(null, "PASSWORD를 확인하세요");
                    }
                }
			  }
		} catch (SQLException e1) {
			System.out.println("문제있음");
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NumberFormatException e3) {
			JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
		}
		
    }
}
