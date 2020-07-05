package com.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.LoginTest;
import com.model.member;
import com.model.reservationDAOImpl;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class choiceView extends JFrame {

    private JPanel contentPane;
    private JPanel panel;
    allowView av = new allowView();

    /**
     * Launch the application.
     */
    /*
     * public static void main(String[] args) { EventQueue.invokeLater(new
     * Runnable() { public void run() { try { System.out.println("choice view");
     * choiceView frame = new choiceView(); frame.setVisible(true); } catch
     * (Exception e) { e.printStackTrace(); } } }); }
     */

    /**
     * Create the frame.
     */
    public choiceView() {
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setBounds(100, 100, 450, 300);
   contentPane = new JPanel();
   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
   setContentPane(contentPane);
   contentPane.setLayout(null);
   panel = new JPanel();
   // JPanel panel = new JPanel();
   panel.setBounds(0, 0, 434, 261);
   contentPane.add(panel);
   panel.setLayout(null);

   JLabel lblNewLabel = new JLabel("\uD56D\uACF5\uAD8C \uC608\uB9E4");
   lblNewLabel.setForeground(new Color(0, 0, 128));
   lblNewLabel.setBounds(65, 10, 208, 34);
   panel.add(lblNewLabel);
   lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
   lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

   JButton btnNewButton = new JButton("ASIAN AIR");
   btnNewButton.addActionListener(new ActionListener() {
   	public void actionPerformed(ActionEvent e) {
 	   reservationDAOImpl rd = new reservationDAOImpl();
	   rd.AreservationInsert();
   	}
   });
   btnNewButton.setBounds(27, 70, 105, 72);
   panel.add(btnNewButton);

   JButton btnKoreanAir = new JButton("KOREAN\r\n AIR");
   btnKoreanAir.setBounds(302, 70, 105, 72);
   panel.add(btnKoreanAir);

   JButton btnBusanAir = new JButton("BUSAN AIR");
   btnBusanAir.addActionListener(new ActionListener() {
   	public void actionPerformed(ActionEvent arg0) {
 	   reservationDAOImpl rd = new reservationDAOImpl();
	   rd.BreservationInsert();
   	}
   });
   btnBusanAir.setBounds(166, 70, 105, 72);
   panel.add(btnBusanAir);

   JButton btnNewButton_1 = new JButton("BACK");
   btnNewButton_1.setBounds(27, 185, 105, 45);
   panel.add(btnNewButton_1);
   btnNewButton_1.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
      av.addUserInfo(LoginTest.memberMap.get(LoginTest.MemberKey));
      av.addBackGround();
      av.setVisible(true);
      dispose();
       }
   });
   
   btnKoreanAir.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
    	   reservationDAOImpl rd = new reservationDAOImpl();
    	   rd.KreservationInsert();
       }
   });
    }
    public void addUserInfo(member member) {

   JLabel userLabel = new JLabel( member.getAccount());
   userLabel.setBounds(300, 5, 108, 84);
   userLabel.setForeground(Color.yellow);
   userLabel.setHorizontalAlignment(SwingConstants.CENTER);
   userLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
   panel.add(userLabel);

    }

    public void addBackGround() {
   JLabel background = new JLabel("");
   background.setBounds(0, 0, 434, 261);
   panel.add(background);
   background.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 16));
   background.setHorizontalAlignment(SwingConstants.CENTER);
   background.setForeground(Color.WHITE);
   background.setIcon(new ImageIcon("src\\img\\planes.jpg"));
    }
}