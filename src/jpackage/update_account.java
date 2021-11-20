package jpackage;

import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URISyntaxException;

import jpackage.*;

public class update_account extends JFrame implements ActionListener, login_user {

    JButton b1, b2, b3, b4;
    String user_user_name;

    public update_account(JFrame f, String user_username) {
        user_user_name = user_username;
        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        b1 = new JButton("Change Username");
        b1.setBounds(670, 200, 250, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Change Password");
        b2.setBounds(670, 300, 250, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Change Phone Number");
        b3.setBounds(670, 400, 250, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton("Go back to Menu");
        b4.setBounds(705, 500, 180, 50);
        b4.setFont(new Font("Helvetica", Font.BOLD, 17));
        b4.addActionListener(this);
        b4.setBackground(Color.RED);
        b4.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b4);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == b1) {

            new update_username(f, user_user_name);

        }

        if (e.getSource() == b2) {

            new update_password(f, user_user_name);

        }

        if (e.getSource() == b3) {

            new update_number(f, user_user_name);

        }

        if (e.getSource() == b4) {

            new account_settings(f, user_user_name);

        }
    }
}

class update_username extends JFrame implements ActionListener, login_user {

    JLabel l, l1, l2, l3, l4;
    JButton b1, b2;
    JTextField t1, t2;
    JPasswordField t3;
    JCheckBox showpassword;
    String user_user_name;

    public update_username(JFrame f, String user_username) {
        user_user_name = user_username;
        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l4 = new JLabel("Update Your Username");
        l4.setBounds(630, 140, 500, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 26));
        l4.setForeground(Color.RED);
        f.add(l4);

        l1 = new JLabel("Enter Your Username:");
        l1.setBounds(530, 240, 250, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(760, 240, 250, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Enter New Username:");
        l2.setBounds(530, 340, 250, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundJTextField(15);
        t2.setBounds(760, 340, 250, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        l3 = new JLabel("Enter Your Password:");
        l3.setBounds(530, 440, 250, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);
        t3 = new RoundPasswordField(15);
        t3.setBounds(760, 440, 250, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t3);

        showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(760, 480, 150, 30);
        showpassword.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword.addActionListener(this);
        showpassword.setOpaque(false);
        showpassword.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(showpassword);

        b1 = new JButton("Change Username");
        b1.setBounds(650, 540, 270, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b1);

        b2 = new JButton("Go back to Account Settings");
        b2.setBounds(650, 630, 270, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == b1) {

            String old_username = t1.getText();
            String new_username = t2.getText();
            String user_password = t3.getText();

            String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
            String username_db = "tklsjaddlzcmwj";
            String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";
            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                String username_check = "SELECT CASE WHEN EXISTS ( SELECT * FROM user_account WHERE username=? and user_password=crypt(?,user_password)) THEN 'TRUEUSER' ELSE 'FALSE' END";

                PreparedStatement statement_check_username = connection.prepareStatement(username_check);

                statement_check_username.setString(1, old_username);
                statement_check_username.setString(2, user_password);

                ResultSet check = statement_check_username.executeQuery();

                while (check.next()) {
                    String value = check.getString("case");
                    if (value.equals("TRUEUSER")) {
                        String update_username = "update user_account set username=? where username=?";
                        String update_username_his = "update appointment_history set user_username=? where user_username=?";

                        PreparedStatement statement_update_username = connection.prepareStatement(update_username);
                        PreparedStatement statement_update_username_his = connection
                                .prepareStatement(update_username_his);

                        statement_update_username.setString(1, new_username);
                        statement_update_username.setString(2, old_username);

                        statement_update_username_his.setString(1, new_username);
                        statement_update_username_his.setString(2, old_username);

                        statement_update_username.executeUpdate();
                        statement_update_username_his.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Username Updated Successfully");
                        new menu(f, user_user_name);

                    }

                    else {
                        JOptionPane.showMessageDialog(null, "No Such User Present");

                    }
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Server Error");
            }
        }

        if (e.getSource() == b2) {

            new update_account(f, user_user_name);

        }

        if (e.getSource() == showpassword) {
            if (showpassword.isSelected()) {
                t3.setEchoChar((char) 0);
            } else {
                t3.setEchoChar('\u2022');
            }
        }

    }
}

class update_password extends JFrame implements ActionListener, login_user {

    JLabel l, l1, l2, l3, l4;
    JButton b1, b2;
    JTextField t1;
    JPasswordField t2, t3;
    JCheckBox showpassword, showpassword1;
    String user_user_name;

    public update_password(JFrame f, String user_username) {
        user_user_name = user_username;
        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l4 = new JLabel("Update Your Password");
        l4.setBounds(630, 140, 500, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 26));
        l4.setForeground(Color.RED);
        f.add(l4);

        l1 = new JLabel("Enter Your Username:");
        l1.setBounds(530, 240, 250, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(760, 240, 250, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Enter Your Password:");
        l2.setBounds(530, 340, 250, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundPasswordField(15);
        t2.setBounds(760, 340, 250, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(760, 380, 150, 30);
        showpassword.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword.addActionListener(this);
        showpassword.setOpaque(false);
        showpassword.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(showpassword);

        l3 = new JLabel("Enter New Password:");
        l3.setBounds(530, 440, 250, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);
        t3 = new RoundPasswordField(15);
        t3.setBounds(760, 440, 250, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t3);

        showpassword1 = new JCheckBox("Show Password");
        showpassword1.setBounds(760, 480, 150, 30);
        showpassword1.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword1.addActionListener(this);
        showpassword1.setOpaque(false);
        showpassword1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(showpassword1);

        b1 = new JButton("Change Password");
        b1.setBounds(650, 540, 270, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b1);

        b2 = new JButton("Go back to Account Settings");
        b2.setBounds(650, 630, 270, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            String username = t1.getText();
            String old_password = t2.getText();
            String new_password = t3.getText();

            String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
            String username_db = "tklsjaddlzcmwj";
            String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";
            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                String username_check = "SELECT CASE WHEN EXISTS ( SELECT * FROM user_account WHERE username=? and user_password=crypt(?,user_password)) THEN 'TRUEUSER' ELSE 'FALSE' END";

                PreparedStatement statement_check_username = connection.prepareStatement(username_check);

                statement_check_username.setString(1, username);
                statement_check_username.setString(2, old_password);

                ResultSet check = statement_check_username.executeQuery();

                while (check.next()) {
                    String value = check.getString("case");
                    if (value.equals("TRUEUSER")) {
                        String update_username = "update user_account set user_password=crypt(?,user_password) where username=?";

                        PreparedStatement statement_update_username = connection.prepareStatement(update_username);

                        statement_update_username.setString(1, new_password);
                        statement_update_username.setString(2, username);

                        statement_update_username.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Password Updated Successfully");
                        new menu(f, user_user_name);

                    }

                    else {
                        JOptionPane.showMessageDialog(null, "No Such User Present");

                    }
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Server Error");
            }
        }

        if (e.getSource() == b2)

        {

            new update_account(f, user_user_name);

        }

        if (e.getSource() == showpassword) {
            if (showpassword.isSelected()) {
                t2.setEchoChar((char) 0);
            } else {
                t2.setEchoChar('\u2022');
            }
        }

        if (e.getSource() == showpassword1) {
            if (showpassword1.isSelected()) {
                t3.setEchoChar((char) 0);
            } else {
                t3.setEchoChar('\u2022');
            }
        }

    }
}

class update_number extends JFrame implements ActionListener, login_user {

    JLabel l, l1, l2, l3, l4;
    JButton b1, b2;
    JTextField t1, t3;
    JPasswordField t2;
    JCheckBox showpassword;
    String user_user_name;

    public update_number(JFrame f, String user_username) {
        user_user_name = user_username;
        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l4 = new JLabel("Update Your Number");
        l4.setBounds(630, 140, 500, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 26));
        l4.setForeground(Color.RED);
        f.add(l4);

        l1 = new JLabel("Enter Your Username:");
        l1.setBounds(530, 240, 250, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(760, 240, 250, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Enter Your Password:");
        l2.setBounds(530, 340, 250, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundPasswordField(15);
        t2.setBounds(760, 340, 250, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(760, 380, 150, 30);
        showpassword.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword.addActionListener(this);
        showpassword.setOpaque(false);
        showpassword.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(showpassword);

        l3 = new JLabel("Enter New Number:");
        l3.setBounds(530, 440, 250, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);
        t3 = new RoundJTextField(15);
        t3.setBounds(760, 440, 250, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t3);

        b1 = new JButton("Change Number");
        b1.setBounds(650, 540, 270, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b1);

        b2 = new JButton("Go back to Account Settings");
        b2.setBounds(650, 630, 270, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == b1) {

            String username = t1.getText();
            String password = t2.getText();
            String new_contact = t3.getText();

            String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
            String username_db = "tklsjaddlzcmwj";
            String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";
            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                if (new_contact.length() == 10) {

                    String username_check = "SELECT CASE WHEN EXISTS ( SELECT * FROM user_account WHERE username=? and user_password=crypt(?,user_password)) THEN 'TRUEUSER' ELSE 'FALSE' END";

                    PreparedStatement statement_check_username = connection.prepareStatement(username_check);

                    statement_check_username.setString(1, username);
                    statement_check_username.setString(2, password);

                    ResultSet check = statement_check_username.executeQuery();

                    while (check.next()) {
                        String value = check.getString("case");
                        if (value.equals("TRUEUSER")) {
                            String update_contact = "update user_account set mobile_no=? where username=?";

                            PreparedStatement statement_update_username = connection.prepareStatement(update_contact);

                            statement_update_username.setString(1, new_contact);
                            statement_update_username.setString(2, username);

                            statement_update_username.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Mobile Number Updated Successfully");
                            new menu(f, user_user_name);

                        }

                        else {
                            JOptionPane.showMessageDialog(null, "No Such User Present");

                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
                }
            }

            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

        if (e.getSource() == b2)

        {

            new update_account(f, user_user_name);

        }

        if (e.getSource() == showpassword) {
            if (showpassword.isSelected()) {
                t2.setEchoChar((char) 0);
            } else {
                t2.setEchoChar('\u2022');
            }
        }

    }
}
