package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.friend;
import com.model.friendDAOImpl;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class view extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private JLabel tfBirth;
	private JTextField tfSearch;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextArea	textArea;
	friendDAOImpl dao = new friendDAOImpl();
	
	private void clearText() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_5.setText("");
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view frame = new view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public view() {
		setFont(new Font("HY궁서B", Font.BOLD, 15));
		setTitle("친구 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 946, 504);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(127, 27, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel tfName = new JLabel("이름");
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setBounds(12, 30, 57, 15);
		panel.add(tfName);
		
		tfBirth = new JLabel("생일");
		tfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		tfBirth.setBounds(12, 74, 57, 15);
		panel.add(tfBirth);
		
		JLabel tfPhone = new JLabel("전화번호");
		tfPhone.setHorizontalAlignment(SwingConstants.CENTER);
		tfPhone.setBounds(12, 117, 57, 15);
		panel.add(tfPhone);
		
		JLabel tfAddr = new JLabel("주소");
		tfAddr.setHorizontalAlignment(SwingConstants.CENTER);
		tfAddr.setBounds(12, 166, 57, 15);
		panel.add(tfAddr);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 71, 116, 21);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(127, 114, 116, 21);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(127, 163, 116, 21);
		panel.add(textField_3);
		
		JButton btnView = new JButton("전체보기");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");
				
				ArrayList<friend>array	= dao.friendView();
				for(friend f : array) {
					textArea.append("번호 : "+f.getNum()+"\n");
					textArea.append("이름 : "+f.getName()+"\n");
					textArea.append("생일 : "+f.getBirth()+"\n");
					textArea.append("전화번호 : "+f.getPhone()+"\n");
					textArea.append("주소 : "+f.getAddr()+"\n");
					textArea.append("\t");
				}
			}
		});
		btnView.setBounds(12, 342, 97, 23);
		panel.add(btnView);
		
		JButton btnInsert = new JButton("친구등록");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				friend f = new friend();
				f.setName(textField.getText());
				f.setBirth(textField_1.getText());
				f.setPhone(textField_2.getText());
				f.setAddr(textField_3.getText());
				dao.friendInsert(f);
				btnView.doClick();
				clearText();
			}
		});
		btnInsert.setBounds(146, 342, 97, 23);
		panel.add(btnInsert);
		
		JButton btnUpdate = new JButton("수정하기");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				friend f = new friend();
				f.setName(textField.getText());
				f.setBirth(textField_1.getText());
				f.setPhone(textField_2.getText());
				f.setAddr(textField_3.getText());
				f.setNum(Integer.parseInt(textField_5.getText()));
				dao.friendUpdate(f);
				btnView.doClick();
				clearText();
			}
		});
		btnUpdate.setBounds(12, 438, 97, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제하기");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num = Integer.parseInt(textField_5.getText());
				dao.friendDelete(num);
				btnView.doClick();
				clearText();
			}
		});
		btnDelete.setBounds(146, 438, 97, 23);
		panel.add(btnDelete);
		
		JLabel tfNum = new JLabel("번호");
		tfNum.setHorizontalAlignment(SwingConstants.CENTER);
		tfNum.setBounds(12, 391, 57, 15);
		panel.add(tfNum);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setBounds(127, 388, 116, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("새로고침");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearText();
				textArea.setText("");
				tfSearch.setText("");
				
			}
		});
		btnNewButton.setBounds(297, 342, 97, 23);
		panel.add(btnNewButton);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setRightComponent(panel_1);
		
		JComboBox jcb = new JComboBox();
		jcb.setModel(new DefaultComboBoxModel(new String[] {"선택", "이름", "주소"}));
		jcb.setPreferredSize(new Dimension(70, 25));
		panel_1.add(jcb);
		
		tfSearch = new JTextField();
		panel_1.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				int idx = jcb.getSelectedIndex();
				String key = "";
				if(idx==1) {
					key = "name";
				}else if(idx==2) {
					key="addr";
				}
				
				ArrayList<friend> array = dao.friendSearch(key,tfSearch.getText());
				for(friend f : array) {
					textArea.append("번호 : "+f.getNum()+"\n");
					textArea.append("이름 : "+f.getName()+"\n");
					textArea.append("생일 : "+f.getBirth()+"\n");
					textArea.append("전화번호 : "+f.getPhone()+"\n");
					textArea.append("주소 : "+f.getAddr()+"\n");
					textArea.append("\n");
				}
			}
		});
		panel_1.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		splitPane_1.setDividerLocation(300);
		splitPane.setDividerLocation(430);
	}
}
