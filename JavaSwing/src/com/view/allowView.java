package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model. LoginTest;
import com.model.member;
import com.model.schedule;
import com.model.scheduleDAOImpl;

import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;


public class allowView extends JFrame {


    private JPanel contentPane;
    private JTextField tfdepart;
    private JTextField tfarrive;
    scheduleDAOImpl schDao = new scheduleDAOImpl();

    /**
     * Create the frame.
     */
    public allowView() {
   setTitle("Reservation Ticket");

   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setBounds(0, 0, 1250, 653);
   contentPane = new JPanel();
   setContentPane(contentPane);
   contentPane.setLayout(null);

   JButton btnBack = new JButton("BACK");
   btnBack.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent arg0) {
      view frame1 = new view();
      frame1.setVisible(true);
      dispose();
       }
   });

   JScrollPane scrollPane = new JScrollPane();
   scrollPane.setForeground(Color.WHITE);
   scrollPane.setBounds(375, 5, 217, 125);
   contentPane.add(scrollPane);

   JTextArea textArea = new JTextArea();
   textArea.setBackground(Color.BLACK);
   textArea.setForeground(Color.WHITE);
   textArea.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
   scrollPane.setViewportView(textArea);
   btnBack.setBounds(339, 187, 67, 23);
   contentPane.add(btnBack);
   /*
    * JLabel lblLogin = new JLabel(); lblLogin.setForeground(Color.WHITE);
    * lblLogin.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
    * lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
    * lblLogin.setBounds(200, 264, 108, 84); contentPane.add(lblLogin);
    */
   JLabel lblDeparture = new JLabel("DEPARTURE");
   lblDeparture.setBounds(339, 258, 117, 23);
   contentPane.add(lblDeparture);
   lblDeparture.setForeground(Color.WHITE);
   lblDeparture.setHorizontalAlignment(SwingConstants.LEFT);
   lblDeparture.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));

   tfdepart = new JTextField();
   tfdepart.setBounds(464, 260, 108, 23);
   contentPane.add(tfdepart);
   tfdepart.setHorizontalAlignment(SwingConstants.CENTER);
   tfdepart.setColumns(10);

   // Ãâ¹ßÁö °Ë»ö
   JButton btnSearch = new JButton("SEARCH");
   btnSearch.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
      textArea.setText("");
      String dep = "dep";
      ArrayList<schedule> arr = schDao.departureSearch(dep, tfdepart.getText().toUpperCase());
      for (schedule sch : arr) {
          textArea.append("AIRLINE : " + sch.getAirline() + "\n");
          textArea.append("DEP : " + sch.getDep() + "\n");
          textArea.append("ARR : " + sch.getArr() + "\n");
          textArea.append("YEAR : " + sch.getYear() + "\n");
          textArea.append("MONTH : " + sch.getMonth() + "\n");
          textArea.append("------------------------" + "\n");
      }
       }
   });
   btnSearch.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
   btnSearch.setBounds(594, 259, 97, 23);
   contentPane.add(btnSearch);

   JLabel lblArrive = new JLabel("ARRIVE");
   lblArrive.setBounds(339, 291, 117, 23);
   contentPane.add(lblArrive);
   lblArrive.setForeground(Color.WHITE);
   lblArrive.setHorizontalAlignment(SwingConstants.LEFT);
   lblArrive.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));

   tfarrive = new JTextField();
   tfarrive.setBounds(464, 293, 108, 23);
   contentPane.add(tfarrive);
   tfarrive.setHorizontalAlignment(SwingConstants.CENTER);
   tfarrive.setColumns(10);

   // µµÂøÁö °Ë»ö
   JButton btnSearch1 = new JButton("SEARCH");
   btnSearch1.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
      textArea.setText("");
      String arrive = "arr";
      ArrayList<schedule> arr = schDao.arriveSearch(arrive, tfarrive.getText().toUpperCase());
      for (schedule sch : arr) {
          textArea.append("AIRLINE : " + sch.getAirline() + "\n");
          textArea.append("DEP : " + sch.getDep() + "\n");
          textArea.append("ARR : " + sch.getArr() + "\n");
          textArea.append("YEAR : " + sch.getYear() + "\n");
          textArea.append("MONTH : " + sch.getMonth() + "\n");
          textArea.append("------------------------" + "\n");
      }
       }
   });
   btnSearch1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
   btnSearch1.setBounds(594, 292, 97, 23);
   contentPane.add(btnSearch1);

   JLabel lblSchedule = new JLabel("SCHEDULE");
   lblSchedule.setBounds(339, 324, 117, 23);
   contentPane.add(lblSchedule);
   lblSchedule.setForeground(Color.WHITE);
   lblSchedule.setHorizontalAlignment(SwingConstants.LEFT);
   lblSchedule.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));

   JComboBox comboBox = new JComboBox();
   comboBox.setBounds(464, 326, 67, 21);
   contentPane.add(comboBox);
   comboBox.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
   comboBox.setModel(new DefaultComboBoxModel(new String[] { "YEAR", "2020", "2021" }));

   JLabel lblYear = new JLabel("YEAR");
   lblYear.setBounds(543, 326, 41, 23);
   contentPane.add(lblYear);
   lblYear.setForeground(Color.WHITE);
   lblYear.setHorizontalAlignment(SwingConstants.CENTER);
   lblYear.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));

   // ³â Á¶È¸
   JButton btnSearch2 = new JButton("SEARCH");
   btnSearch2.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
      int idx = comboBox.getSelectedIndex();
      int key = 0;
      String ye = "year";
      if (idx == 1) {
          textArea.setText("");
          key = 2020;
      } else if (idx == 2) {
          textArea.setText("");
          key = 2021;
      }
      ArrayList<schedule> array = schDao.schSearch(ye, key);
      for (schedule sch : array) {
          textArea.append("AIRLINE : " + sch.getAirline() + "\n");
          textArea.append("DEP : " + sch.getDep() + "\n");
          textArea.append("ARR : " + sch.getArr() + "\n");
          textArea.append("YEAR : " + sch.getYear() + "\n");
          textArea.append("MONTH : " + sch.getMonth() + "\n");
          textArea.append("------------------------" + "\n");
      }
       }
   });

   btnSearch2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
   btnSearch2.setBounds(594, 325, 97, 23);
   contentPane.add(btnSearch2);

   // ÀüÃ¼ ½ºÄÉÁì Á¶È¸ ±â´É
   JButton btnNewButton = new JButton("All SCHEDULE");
   btnNewButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
      textArea.setText("");
      ArrayList<schedule> arr = schDao.scheduleView();
      for (schedule sch : arr) {
          textArea.append("AIRLINE : " + sch.getAirline() + "\n");
          textArea.append("DEP : " + sch.getDep() + "\n");
          textArea.append("ARR : " + sch.getArr() + "\n");
          textArea.append("YEAR : " + sch.getYear() + "\n");
          textArea.append("MONTH : " + sch.getMonth() + "\n");
          textArea.append("\n");
      }
       }
   });

   btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
   btnNewButton.setBounds(543, 187, 108, 23);
   contentPane.add(btnNewButton);

   // ¿¹¸ÅÇÏ±â ¹öÆ°
   JButton btnReser = new JButton("\uC608\uB9E4\uD558\uAE30");
   btnReser.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
      choiceView cv = new choiceView();
      cv.addUserInfo(LoginTest.memberMap.get(LoginTest.MemberKey));
      cv.addBackGround();
      cv.setVisible(true);
      dispose();
       }
   });

   btnReser.setBounds(464, 402, 128, 44);
   contentPane.add(btnReser);

    }

    // ·Î±×ÀÎ Á¤º¸ Ç¥½Ã
    public void addUserInfo(member member) {

   JLabel userLabel = new JLabel(member.getAccount());
   userLabel.setBounds(200, 264, 108, 84);
   userLabel.setForeground(Color.WHITE);
   userLabel.setHorizontalAlignment(SwingConstants.LEFT);
   userLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
   contentPane.add(userLabel);

    }
    
    // ¹è°æÈ­¸é Ç¥½Ã
    public void addBackGround() {
   JLabel background = new JLabel("");
   background.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 16));
   background.setHorizontalAlignment(SwingConstants.CENTER);
   background.setForeground(Color.WHITE);
   background.setIcon(new ImageIcon("src\\img\\terminal.jpg"));
   background.setBounds(0, 0, 1234, 614);
   background.setBackground(Color.WHITE);
   contentPane.add(background);
    }
}
