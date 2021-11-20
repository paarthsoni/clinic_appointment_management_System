package jpackage;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URISyntaxException;

import jpackage.*;

public class another_admin extends JFrame implements login_user, ActionListener {

    JLabel l, l1, l2, l3, l4;
    JButton button1, b2;
    JTextField t1, t2;
    JPasswordField t3, t4;
    JCheckBox showpassword, showpassword1;
    String admin_user_name;

    public another_admin(JFrame f, String admin_username) {
        admin_user_name = admin_username;

        f.getContentPane().removeAll();
        f.repaint();
        // f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l = new JLabel("Create Admin Account");
        l.setBounds(630, 80, 400, 30);
        l.setFont(new Font("Helvetica", Font.BOLD, 26));
        l.setForeground(Color.red);
        f.add(l);

        l1 = new JLabel("Full Name:");
        l1.setBounds(710, 140, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(490, 180, 532, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Username:");
        l2.setBounds(710, 220, 225, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundJTextField(15);
        t2.setBounds(490, 260, 532, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        l3 = new JLabel("Enter your Password:");
        l3.setBounds(655, 300, 225, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);
        t3 = new RoundPasswordField(15);
        t3.setBounds(490, 340, 532, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t3);

        showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(680, 370, 150, 30);
        showpassword.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword.addActionListener(this);
        showpassword.setOpaque(false);
        showpassword.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(showpassword);

        l4 = new JLabel("Confirm your Password:");
        l4.setBounds(650, 410, 250, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 20));
        l4.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l4);
        t4 = new RoundPasswordField(15);
        t4.setBounds(490, 450, 532, 30);
        t4.setBackground(Color.white);
        t4.setForeground(Color.black);
        t4.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t4);

        showpassword1 = new JCheckBox("Show Password");
        showpassword1.setBounds(680, 480, 150, 30);
        showpassword1.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword1.addActionListener(this);
        showpassword1.setOpaque(false);
        showpassword1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(showpassword1);

        b2 = new JButton("Go Back to Menu");
        b2.setBounds(770, 540, 250, 35);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        b2.setBackground(Color.red);
        b2.addActionListener(this);
        f.add(b2);

        button1 = new JButton("Create Admin Account");
        button1.setBounds(490, 540, 250, 35);
        button1.setFont(new Font("Helvetica", Font.BOLD, 17));
        button1.setBackground(Color.GREEN);
        button1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        button1.addActionListener(this);
        f.add(button1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            String fullname = t1.getText();
            String adminusername = t2.getText();
            String adminpassword = t3.getText();
            String confirmpassword = t4.getText();
            boolean data = fullname.matches("^[a-zA-Z\\s]*$");
            String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
            String username_db = "tklsjaddlzcmwj";
            String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";

            if ((!t1.getText().equals("")) && (!t2.getText().equals("")) && (!t3.getText().equals(""))
                    && (!t4.getText().equals(""))) {
                if ((data) && adminusername.length() <= 15 && adminpassword.equals(confirmpassword)) {
                    try {
                        Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                        String username_check = "SELECT CASE WHEN EXISTS ( SELECT * FROM admin_account WHERE admin_username=?) THEN 'TRUE' ELSE 'FALSE' END";

                        PreparedStatement statementcheck = connection.prepareStatement(username_check);

                        statementcheck.setString(1, adminusername);
                        ResultSet check = statementcheck.executeQuery();

                        while (check.next()) {
                            String value = check.getString("case");
                            if (value.equals("FALSE")) {
                                String insert = "insert into admin_account values(?,?,crypt(?,gen_salt('bf')))";
                                PreparedStatement statementinsert = connection.prepareStatement(insert);

                                statementinsert.setString(1, fullname);
                                statementinsert.setString(2, adminusername);
                                statementinsert.setString(3, adminpassword);
                                statementinsert.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Admin Account Created Successfully");
                                new admin_menu(f, admin_user_name);

                            } else if (value.equals("TRUE")) {
                                JOptionPane.showMessageDialog(null, "Username is not available");
                            }
                        }

                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, "Server Error");
                    }

                } else if ((!data)) {
                    JOptionPane.showMessageDialog(null, "Only Characters are allowed for Name");
                } else if (adminusername.length() > 15) {
                    JOptionPane.showMessageDialog(null, "Username should not exceed 15 characters");
                } else if ((!adminpassword.equals(confirmpassword))) {
                    JOptionPane.showMessageDialog(null, "Entered Password and Confirm Password does not match");
                }

            } else {
                JOptionPane.showMessageDialog(null, "All Inputs are required");
            }
        }

        if (e.getSource() == b2) {
            new admin_menu(f, admin_user_name);
        }

        if (e.getSource() == showpassword) {
            if (showpassword.isSelected()) {
                t3.setEchoChar((char) 0);
            } else {
                t3.setEchoChar('\u2022');
            }
        }

        if (e.getSource() == showpassword1) {
            if (showpassword1.isSelected()) {
                t4.setEchoChar((char) 0);
            } else {
                t4.setEchoChar('\u2022');
            }
        }

    }

}
