package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class seatView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seatView frame = new seatView();
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
	public seatView() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 622, 344);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceView cv = new choiceView();
				cv.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(12, 34, 67, 23);
		panel.add(btnNewButton);
		
		JButton btnSeat1 = new JButton("seat1");
		btnSeat1.setBounds(53, 83, 97, 72);
		panel.add(btnSeat1);
		
		JButton btnSeat2 = new JButton("seat2");
		btnSeat2.setBounds(53, 165, 97, 72);
		panel.add(btnSeat2);
		
		JButton btnSeat3 = new JButton("seat3");
		btnSeat3.setBounds(53, 247, 97, 72);
		panel.add(btnSeat3);
		
		JButton btnSeat4 = new JButton("seat4");
		btnSeat4.setBounds(183, 83, 97, 72);
		panel.add(btnSeat4);
		
		JButton btnSeat5 = new JButton("seat5");
		btnSeat5.setBounds(183, 165, 97, 72);
		panel.add(btnSeat5);
		
		JButton btnSeat6 = new JButton("seat6");
		btnSeat6.setBounds(183, 247, 97, 72);
		panel.add(btnSeat6);
		
		JButton btnSeat7 = new JButton("seat7");
		btnSeat7.setBounds(308, 83, 97, 72);
		panel.add(btnSeat7);
		
		JButton btnSeat8 = new JButton("seat8");
		btnSeat8.setBounds(308, 165, 97, 72);
		panel.add(btnSeat8);
		
		JButton btnSeat9 = new JButton("seat9");
		btnSeat9.setBounds(308, 247, 97, 72);
		panel.add(btnSeat9);
		
		JButton btnSeat10 = new JButton("seat10");
		btnSeat10.setBounds(434, 83, 97, 72);
		panel.add(btnSeat10);
		
		JButton btnSeat11 = new JButton("seat11");
		btnSeat11.setBounds(434, 247, 97, 72);
		panel.add(btnSeat11);
		
		JButton btnSeat12 = new JButton("seat12");
		btnSeat12.setBounds(434, 165, 97, 72);
		panel.add(btnSeat12);
	}
}
