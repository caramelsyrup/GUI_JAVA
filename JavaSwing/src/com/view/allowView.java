package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.LoginTest;

import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;

public class allowView extends JFrame {

	private JPanel contentPane;
	private JTextField tfdepart;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		view w = new view();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allowView frame = new allowView();
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
	public allowView() {
		setTitle("Reservation Ticket");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1250, 653);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		 JTextPane textPane = new JTextPane();
		 textPane.setBounds(400, 35, 435, 125);
		 contentPane.add(textPane);
		 
		 JLabel lblNewLabel = new JLabel("AIRLINE");
		 lblNewLabel.setBounds(339, 225, 117, 23);
		 contentPane.add(lblNewLabel);
		 lblNewLabel.setForeground(Color.WHITE);
		 lblNewLabel.setFont(new Font("���� ����", Font.BOLD, 15));
		 lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		 
		 JRadioButton rdbtnKoreanAir_1 = new JRadioButton("KOREAN AIR");
		 rdbtnKoreanAir_1.setForeground(new Color(0, 0, 0));
		 rdbtnKoreanAir_1.setBorder(null);
		 rdbtnKoreanAir_1.setBackground(Color.WHITE);
		 rdbtnKoreanAir_1.setBounds(464, 226, 121, 23);
		 contentPane.add(rdbtnKoreanAir_1);
		 rdbtnKoreanAir_1.setHorizontalAlignment(SwingConstants.CENTER);
		 rdbtnKoreanAir_1.setFont(new Font("���� ����", Font.BOLD, 13));
		 
		 JRadioButton rdbtnAsianAir = new JRadioButton("ASIAN AIR");
		 rdbtnAsianAir.setBounds(589, 226, 121, 23);
		 contentPane.add(rdbtnAsianAir);
		 rdbtnAsianAir.setHorizontalAlignment(SwingConstants.CENTER);
		 rdbtnAsianAir.setFont(new Font("���� ����", Font.BOLD, 13));
		 
		 JRadioButton rdbtnBusanAir = new JRadioButton("BUSAN AIR");
		 rdbtnBusanAir.setBounds(714, 226, 121, 23);
		 contentPane.add(rdbtnBusanAir);
		 rdbtnBusanAir.setHorizontalAlignment(SwingConstants.CENTER);
		 rdbtnBusanAir.setFont(new Font("���� ����", Font.BOLD, 13));
		 
		 JLabel lblDeparture = new JLabel("DEPARTURE");
		 lblDeparture.setBounds(339, 258, 117, 23);
		 contentPane.add(lblDeparture);
		 lblDeparture.setForeground(Color.WHITE);
		 lblDeparture.setHorizontalAlignment(SwingConstants.LEFT);
		 lblDeparture.setFont(new Font("���� ����", Font.BOLD, 15));
		 
		 tfdepart = new JTextField();
		 tfdepart.setBounds(464, 260, 108, 23);
		 contentPane.add(tfdepart);
		 tfdepart.setHorizontalAlignment(SwingConstants.CENTER);
		 tfdepart.setColumns(10);
		 
		 JLabel lblArrive = new JLabel("ARRIVE");
		 lblArrive.setBounds(339, 291, 117, 23);
		 contentPane.add(lblArrive);
		 lblArrive.setForeground(Color.WHITE);
		 lblArrive.setHorizontalAlignment(SwingConstants.LEFT);
		 lblArrive.setFont(new Font("���� ����", Font.BOLD, 15));
		 
		 textField = new JTextField();
		 textField.setBounds(464, 293, 108, 23);
		 contentPane.add(textField);
		 textField.setHorizontalAlignment(SwingConstants.CENTER);
		 textField.setColumns(10);
		 
		 JLabel lblSchedule = new JLabel("SCHEDULE");
		 lblSchedule.setBounds(339, 324, 117, 23);
		 contentPane.add(lblSchedule);
		 lblSchedule.setForeground(Color.WHITE);
		 lblSchedule.setHorizontalAlignment(SwingConstants.LEFT);
		 lblSchedule.setFont(new Font("���� ����", Font.BOLD, 15));
		 
		 JComboBox comboBox = new JComboBox();
		 comboBox.setBounds(464, 326, 67, 21);
		 contentPane.add(comboBox);
		 comboBox.setFont(new Font("���� ����", Font.BOLD, 13));
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021"}));
		 
		 JLabel lblYear = new JLabel("YEAR");
		 lblYear.setBounds(543, 326, 41, 23);
		 contentPane.add(lblYear);
		 lblYear.setForeground(Color.WHITE);
		 lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		 lblYear.setFont(new Font("���� ����", Font.BOLD, 15));
		 
		 JComboBox comboBox_1 = new JComboBox();
		 comboBox_1.setFont(new Font("���� ����", Font.BOLD, 13));
		 comboBox_1.setBounds(589, 327, 50, 21);
		 contentPane.add(comboBox_1);
		 comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		 
		 JLabel lblMonth = new JLabel("MONTH");
		 lblMonth.setBounds(651, 324, 59, 23);
		 contentPane.add(lblMonth);
		 lblMonth.setForeground(Color.WHITE);
		 lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		 lblMonth.setFont(new Font("���� ����", Font.BOLD, 15));
		 
		 JButton btnNewButton = new JButton("SEARCH");
		 btnNewButton.setFont(new Font("���� ����", Font.BOLD, 13));
		 btnNewButton.setBounds(738, 326, 97, 23);
		 contentPane.add(btnNewButton);
		 
		 JLabel lblInfo = new JLabel("");
		 lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		 lblInfo.setForeground(Color.WHITE);
		 lblInfo.setBounds(234, 231, 93, 116);
		 contentPane.add(lblInfo);
		 
		 JLabel background = new JLabel("");
		 background.setFont(new Font("����ü", Font.BOLD, 16));
		 background.setHorizontalAlignment(SwingConstants.CENTER);
		 background.setForeground(Color.WHITE);
		 background.setIcon(new ImageIcon("src\\img\\terminal.jpg"));
		 background.setBounds(12, 0, 1262, 673);
		 contentPane.add(background);
	}
}
