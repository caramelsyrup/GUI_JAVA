package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.LoginTest;
import com.model.member;
import com.model.memberDAOImpl;

import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Label;
import java.awt.Canvas;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class view extends JFrame {
	BufferedImage img = null;
    private JPanel contentPane;
    private static JTextField tfAccount;
    private LoginTest loginManager = new LoginTest();
    memberDAOImpl dao = new memberDAOImpl();
    private JTextField tfPwd;
    allowView av = new allowView();
    createView frame = new createView();
    choiceView cv = new choiceView();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

   EventQueue.invokeLater(new Runnable() {
       public void run() {
      try {
          view frame1 = new view();
          frame1.setVisible(true);
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
   setTitle("Reservation for Air-Ticket ");
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setBounds(100, 100, 388, 528);
   contentPane = new JPanel();
   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
   setContentPane(contentPane);
   contentPane.setLayout(null);

   JPanel panel1 = new JPanel();
   panel1.setBounds(0, 0, 372, 489);
   contentPane.add(panel1);
   panel1.setLayout(null);

   JLabel lblTitle = new JLabel("\uD56D\uACF5\uAD8C \uC608\uB9E4 \uC11C\uBE44\uC2A4");
   lblTitle.setFont(new Font("���� ����", Font.BOLD, 20));
   lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
   lblTitle.setBounds(12, 29, 348, 69);
   panel1.add(lblTitle);

   JLabel lblNewLabel = new JLabel("ACCOUNT");
   lblNewLabel.setForeground(Color.BLACK);
   lblNewLabel.setFont(new Font("���� ����", Font.PLAIN, 20));
   lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
   lblNewLabel.setBounds(52, 234, 113, 51);
   panel1.add(lblNewLabel);

   tfAccount = new JTextField();
   tfAccount.setBounds(177, 253, 116, 21);
   panel1.add(tfAccount);
   tfAccount.setColumns(10);

   // �α��ι�ư
   JButton btnConfirm = new JButton("CONFIRM");
   btnConfirm.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
      try {
          // login�� ������ ��� 
          if (!loginManager.accessLogin(tfAccount.getText(), Integer.parseInt(tfPwd.getText()))) {
         // TODO ȸ�� ���� �ܼ� �� ���� �����
         return;
          }
          av.addUserInfo(LoginTest.memberMap.get(LoginTest.MemberKey));
          av.addBackGround();
          av.setVisible(true);
          dispose();
      } catch (NumberFormatException e1) {
          JOptionPane.showMessageDialog(null, "������ �Է��ϼ���.");
      }
       }
   });

   btnConfirm.setFont(new Font("���� ����", Font.PLAIN, 15));
   btnConfirm.setBounds(186, 376, 107, 29);
   panel1.add(btnConfirm);

   JLabel lblPassword = new JLabel("PASSWORD");
   lblPassword.setFont(new Font("���� ����", Font.PLAIN, 20));
   lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
   lblPassword.setBounds(52, 305, 113, 51);
   panel1.add(lblPassword);

   // ȸ������ ��ư
   JButton btnCreate = new JButton("CREATE");
   btnCreate.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
      frame.setVisible(true);
      dispose();
       }
   });

   tfPwd = new JTextField();
   tfPwd.setColumns(10);
   tfPwd.setBounds(177, 324, 116, 21);
   panel1.add(tfPwd);
   btnCreate.setFont(new Font("���� ����", Font.PLAIN, 15));
   btnCreate.setBounds(58, 376, 107, 29);
   panel1.add(btnCreate);

   JButton btnNewButton = new JButton("EXIT");
   btnNewButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent arg0) {
      System.exit(0);
       }
   });
   btnNewButton.setFont(new Font("����", Font.BOLD, 17));
   btnNewButton.setBounds(127, 429, 97, 23);
   panel1.add(btnNewButton);

    }
}
