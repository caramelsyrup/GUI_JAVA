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
			Class.forName("oracle.jdbc.driver.OracleDriver");	// ����Ŭ����̹� �ε�	
			String url	= "jdbc:oracle:thin:@localhost:1521:xe"; 
			String user = "scott";
			String pwd = "1234";
			con = DriverManager.getConnection(url, user, pwd);	// db �����ϰ�, scott���� db����.
			
			sql = "SELECT * FROM member WHERE account ='"+id+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);	// id�� �Է��Ͽ� db�� ������ ���̺� �ڷḦ ������.
			
			if(rs.next() == false || id.isEmpty() == true) {	// id�� ������.
				JOptionPane.showMessageDialog(null, "ACCOUNT�� Ȯ���ϼ���");
			} else {
				sql = "SELECT * FROM member WHERE account = '"+id+"'";
				rs = st.executeQuery(sql);
				while (rs.next() == true) {
                    if (Integer.parseInt(rs.getString(3)) == pw) {	// db�� password�� pw�� ������ ��
                    	JOptionPane.showMessageDialog(null, "�α��μ���");
    					frame.setVisible(true);
    					v.setVisible(false);
                    } else {                
                    	JOptionPane.showMessageDialog(null, "PASSWORD�� Ȯ���ϼ���");
                    }
                }
			  }
		} catch (SQLException e1) {
			System.out.println("��������");
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NumberFormatException e3) {
			JOptionPane.showMessageDialog(null, "�߸� �Է��ϼ̽��ϴ�.");
		}
		
    }
}