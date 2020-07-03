package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.member;
import com.model.memberDAO;
import com.model.memberDAOImpl;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class createView extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfCity;
	private JTextField tfPhone;
	private JTextField tfEmail;

	memberDAOImpl dao = new memberDAOImpl();
	private JTextField tfAccount;
	private JTextField tfPwd;
	private JTextField tfSearchac;
	private JTextField tfSearchpw;
	
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createView frame = new createView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/	
	// text������ �ʱ�ȭ
	private void clearText() {
		tfAccount.setText("");
		tfPwd.setText("");
		tfName.setText("");
		tfBirth.setText("");
		tfCity.setText("");
		tfPhone.setText("");
		tfEmail.setText("");
	}

	/**
	 * Create the frame.
	 */
	public createView() {
		setTitle("CREATE ACCOUNT PAGE");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 507);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 644, 453);
		contentPane.add(panel);
		panel.setBackground(SystemColor.info);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("���� ����", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 214, 49);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view frame1 = new view();
				frame1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("���� ����", Font.BOLD, 12));
		btnNewButton_2.setBounds(562, 10, 65, 26);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("ACCOUNT");
		lblNewLabel_1.setFont(new Font("���� ����", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 85, 86, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblAccount = new JLabel("* 5\uC790\uC774\uC0C1 10\uC790\uC774\uD558");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setFont(new Font("����", Font.PLAIN, 10));
		lblAccount.setBounds(110, 69, 114, 15);
		panel.add(lblAccount);
		
		tfAccount = new JTextField();
		tfAccount.setColumns(10);
		tfAccount.setBounds(110, 90, 116, 21);
		panel.add(tfAccount);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("���� ����", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(12, 136, 86, 26);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblPwd = new JLabel("* 4\uC790\uC774\uC0C1 8\uC790\uC774\uD558");
		lblPwd.setFont(new Font("����", Font.PLAIN, 10));
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setBounds(112, 121, 114, 15);
		panel.add(lblPwd);
		
		tfPwd = new JTextField();
		tfPwd.setColumns(8);
		tfPwd.setBounds(110, 141, 116, 21);
		panel.add(tfPwd);
		
		JLabel lblNewLabel_1_2 = new JLabel("NAME");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("���� ����", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(12, 189, 86, 26);
		panel.add(lblNewLabel_1_2);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(110, 194, 116, 21);
		panel.add(tfName);
		
		JLabel lblNewLabel_1_3 = new JLabel("BIRTH");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("���� ����", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(12, 225, 86, 26);
		panel.add(lblNewLabel_1_3);
		
		tfBirth = new JTextField();
		tfBirth.setColumns(10);
		tfBirth.setBounds(110, 230, 116, 21);
		panel.add(tfBirth);
		
		JLabel lblNewLabel_1_4 = new JLabel("CITY");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("���� ����", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(12, 261, 86, 26);
		panel.add(lblNewLabel_1_4);
		
		tfCity = new JTextField();
		tfCity.setColumns(10);
		tfCity.setBounds(110, 266, 116, 21);
		panel.add(tfCity);
		
		JLabel lblNewLabel_1_5 = new JLabel("PHONE");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("���� ����", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(12, 297, 86, 26);
		panel.add(lblNewLabel_1_5);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(110, 302, 116, 21);
		panel.add(tfPhone);
		
		JLabel lblNewLabel_1_6 = new JLabel("EMAIL");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("���� ����", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(12, 333, 86, 26);
		panel.add(lblNewLabel_1_6);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(110, 338, 116, 21);
		panel.add(tfEmail);
		
		// ȸ������ �ǵ���.
		JButton btnNewButton = new JButton("JOIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					member m = new member();
					m.setAccount(tfAccount.getText());
					m.setPassword(Integer.parseInt(tfPwd.getText()));
					m.setName(tfName.getText());
					m.setBirth(tfBirth.getText());
					m.setCity(tfCity.getText());
					m.setPhone(tfPhone.getText());
					m.setEmail(tfEmail.getText());
					dao.memberInsert(m);
					clearText();
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "�ùٸ��� �Է��ϼ���");
					clearText();
					e.printStackTrace();
				}
			}
		});
		
		
		btnNewButton.setFont(new Font("���� ����", Font.BOLD, 15));
		btnNewButton.setBounds(110, 370, 116, 23);
		panel.add(btnNewButton);
		
		JTextArea taScreen = new JTextArea();
		taScreen.setBounds(364, 64, 235, 202);
		panel.add(taScreen);
		
		JLabel lblSaccount = new JLabel("ACCOUNT");
		lblSaccount.setFont(new Font("���� ����", Font.BOLD, 12));
		lblSaccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaccount.setBounds(312, 305, 71, 15);
		panel.add(lblSaccount);
		
		tfSearchac = new JTextField();
		tfSearchac.setBounds(395, 303, 116, 21);
		panel.add(tfSearchac);
		tfSearchac.setColumns(10);
		
		JLabel lblSpwd = new JLabel("PASSWORD");
		lblSpwd.setFont(new Font("���� ����", Font.BOLD, 12));
		lblSpwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpwd.setBounds(312, 341, 71, 15);
		panel.add(lblSpwd);
		
		tfSearchpw = new JTextField();
		tfSearchpw.setColumns(8);
		tfSearchpw.setBounds(395, 338, 116, 21);
		panel.add(tfSearchpw);
		
		// ���� ���������� ����������.
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<member> arr = dao.memberSearch(tfSearchac.getText(),tfSearchpw.getText());
				for(member m : arr) {
					taScreen.append("��ȣ : "+m.getNum()+"\n");
					taScreen.append("account : "+m.getAccount()+"\n");
					taScreen.append("password : "+m.getPassword()+"\n");
					taScreen.append("�̸� : "+m.getName()+"\n");
					taScreen.append("���� : "+m.getBirth()+"\n");
					taScreen.append("���� : "+m.getCity()+"\n");
					taScreen.append("��ȭ��ȣ : "+m.getPhone()+"\n");
					taScreen.append("�̸��� : "+m.getEmail()+"\n");
					taScreen.append("\n");
				}
			}
		});
		btnView.setFont(new Font("���� ����", Font.BOLD, 15));
		btnView.setBounds(523, 301, 76, 58);
		panel.add(btnView);
		
		JLabel lblNewLabel_2 = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uCC3D");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("���� ����", Font.BOLD, 20));
		lblNewLabel_2.setBounds(349, 10, 214, 49);
		panel.add(lblNewLabel_2);
		
		JLabel lblSaccount_1 = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uAC80\uC0C9");
		lblSaccount_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaccount_1.setFont(new Font("���� ����", Font.BOLD, 12));
		lblSaccount_1.setBounds(374, 278, 114, 15);
		panel.add(lblSaccount_1);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("���� ����", Font.BOLD, 12));
		btnNewButton_1.setBounds(523, 372, 76, 23);
		panel.add(btnNewButton_1);
	}
}
