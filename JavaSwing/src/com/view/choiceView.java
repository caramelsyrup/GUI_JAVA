package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class choiceView extends JFrame {

	private JPanel contentPane;
	allowView av = new allowView();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choiceView frame = new choiceView();
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
	public choiceView() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ASIAN AIR");
		btnNewButton.setBounds(168, 80, 97, 90);
		contentPane.add(btnNewButton);
		
		JButton btnKoreanAir = new JButton("KOREAN\r\n AIR");
		btnKoreanAir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatView sv = new seatView();
				sv.setVisible(true);
				
			}
		});
		btnKoreanAir.setBounds(12, 80, 105, 90);
		contentPane.add(btnKoreanAir);
		
		JButton btnBusanAir = new JButton("BUSAN AIR");
		btnBusanAir.setBounds(317, 80, 105, 90);
		contentPane.add(btnBusanAir);
		
		JLabel lblNewLabel = new JLabel("\uD56D\uACF5\uAD8C \uC608\uB9E4");
		lblNewLabel.setFont(new Font("���� ����", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 410, 60);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				av.setVisible(true);
				 dispose();
			}
		});
		btnNewButton_1.setBounds(12, 209, 97, 23);
		contentPane.add(btnNewButton_1);
	}
}
