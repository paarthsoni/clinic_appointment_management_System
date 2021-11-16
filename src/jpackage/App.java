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

interface login_user {

    static JFrame f = new JFrame("Clinic appointment Management System");

}

// Aayush - Create account class - start
class create_account extends JFrame implements ActionListener {
    JLabel l, l1, l2, l3, l4, l5, l6;
    JButton button1, b2;
    JTextField t1, t2, t3, t4;
    JPasswordField t5, t6;
    JCheckBox showpassword, showpassword1;

    public create_account(JFrame f) {
        f.getContentPane().removeAll();
        f.repaint();
        // f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l = new JLabel("Create your Account");
        l.setBounds(640, 80, 400, 30);
        l.setFont(new Font("Helvetica", Font.BOLD, 26));
        l.setForeground(Color.red);
        f.add(l);

        l1 = new JLabel("First Name:");
        l1.setBounds(565, 140, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(490, 180, 250, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Last Name:");
        l2.setBounds(845, 140, 225, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundJTextField(15);
        t2.setBounds(770, 180, 250, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        l3 = new JLabel("Mobile Number:");
        l3.setBounds(680, 220, 225, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);
        t3 = new RoundJTextField(15);
        t3.setBounds(490, 260, 532, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t3);

        l4 = new JLabel("Username:");
        l4.setBounds(710, 300, 225, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 20));
        l4.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l4);
        t4 = new RoundJTextField(15);
        t4.setBounds(490, 340, 532, 30);
        t4.setBackground(Color.white);
        t4.setForeground(Color.black);
        t4.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t4);

        l5 = new JLabel("Enter your Password:");
        l5.setBounds(655, 380, 225, 30);
        l5.setFont(new Font("Helvetica", Font.BOLD, 20));
        l5.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l5);
        t5 = new RoundPasswordField(15);
        t5.setBounds(490, 420, 532, 30);
        t5.setBackground(Color.white);
        t5.setForeground(Color.black);
        t5.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t5);

        showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(680, 450, 150, 30);
        showpassword.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword.addActionListener(this);
        showpassword.setOpaque(false);
        showpassword.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(showpassword);

        l6 = new JLabel("Confirm your Password:");
        l6.setBounds(650, 490, 250, 30);
        l6.setFont(new Font("Helvetica", Font.BOLD, 20));
        l6.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l6);
        t6 = new RoundPasswordField(15);
        t6.setBounds(490, 530, 532, 30);
        t6.setBackground(Color.white);
        t6.setForeground(Color.black);
        t6.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t6);

        showpassword1 = new JCheckBox("Show Password");
        showpassword1.setBounds(680, 560, 150, 30);
        showpassword1.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword1.addActionListener(this);
        showpassword1.setOpaque(false);
        showpassword1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(showpassword1);

        b2 = new JButton("Go Back to login");
        b2.setBounds(770, 620, 250, 35);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        button1 = new JButton("Create Account");
        button1.setBounds(490, 620, 250, 35);
        button1.setFont(new Font("Helvetica", Font.BOLD, 17));
        button1.addActionListener(this);
        f.add(button1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == showpassword) {
            if (showpassword.isSelected()) {
                t5.setEchoChar((char) 0);
            } else {
                t5.setEchoChar('\u2022');
            }
        }

        if (e.getSource() == showpassword1) {
            if (showpassword1.isSelected()) {
                t6.setEchoChar((char) 0);
            } else {
                t6.setEchoChar('\u2022');
            }
        }

        if (e.getSource() == button1) {
            String f_name = t1.getText();
            String l_name = t2.getText();
            String mobile_no = t3.getText();
            String user_name = t4.getText();

            String user_password = t5.getText();
            String confirm_password = t6.getText();
            String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
            String username_db = "tklsjaddlzcmwj";
            String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";

            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);
                Long contact = Long.parseLong(mobile_no);
                boolean data = f_name.matches("[a-zA-Z]+");
                boolean data1 = l_name.matches("[a-zA-Z]+");
                boolean data2 = mobile_no.matches("[0-9]+");

                if ((!t1.getText().equals("")) && (!t2.getText().equals("")) && (!t3.getText().equals(""))
                        && (!t4.getText().equals("")) && (!t5.getText().equals("")) && (!t6.getText().equals(""))) {

                    String sqlquery = "SELECT CASE WHEN EXISTS ( SELECT * FROM user_account WHERE username=?) THEN 'TRUEUSER' ELSE 'FALSE' END";
                    PreparedStatement statementcheck = connection.prepareStatement(sqlquery);
                    statementcheck.setString(1, user_name);

                    ResultSet user_name_check = statementcheck.executeQuery();
                    while (user_name_check.next()) {
                        String value = user_name_check.getString("case");

                        if (value.equals("TRUEUSER")) {
                            JOptionPane.showMessageDialog(null, "Username not Available");
                        } else {

                            if ((data) && (data1) && (data2) && mobile_no.length() == 10 && user_name.length() <= 15
                                    && user_password.equals(confirm_password)) {
                                String sql_insert = "INSERT INTO user_account (fname,lname,username,user_password,mobile_no) VALUES (?,?,?,crypt(?,gen_salt('bf')),?)";

                                PreparedStatement statement_insert = connection.prepareStatement(sql_insert);
                                statement_insert.setString(1, f_name);
                                statement_insert.setString(2, l_name);
                                statement_insert.setString(3, user_name);
                                statement_insert.setString(4, user_password);
                                statement_insert.setLong(5, contact);

                                statement_insert.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Account created Successfully");
                                new login();

                            } else if ((!data)) {
                                JOptionPane.showMessageDialog(null, "Only Characters are allowed for First Name");
                            } else if ((!data1)) {
                                JOptionPane.showMessageDialog(null, "Only Characters are allowed for Last Name");
                            } else if ((!data2)) {
                                JOptionPane.showMessageDialog(null, "Only Characters are allowed for Last Name");
                            } else if (mobile_no.length() != 10) {
                                JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
                            } else if (user_name.length() > 15) {
                                JOptionPane.showMessageDialog(null, "Username should not exceed 15 characters");
                            } else if (!user_password.equals(confirm_password)) {
                                JOptionPane.showMessageDialog(null,
                                        "Entered password does not match the Confirm Password");
                            }
                        }
                    }

                    connection.close();
                } else {
                    JOptionPane.showMessageDialog(null, "All Input Fields are Required");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Server Error!!");
            }

            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "All Input Fields are required");
            }

        }

        if (e.getSource() == b2) {

            new login();

        }

    }

}
// end

class login extends JFrame implements login_user, ActionListener {
    JLabel l, l1, l2, l3, l4;
    JButton b1, b2, b3;
    JTextField t1;
    JPasswordField t2;
    JCheckBox showpassword;
    String user_username;

    public login() {

        f.getContentPane().removeAll();
        f.repaint();

        // JLabel background = new JLabel(new ImageIcon(
        // "E:\\Clinic_appointment_management_system\\clinic_appointment_management_System\\src\\jpackage\\image.jpg"));

        JLabel background = new JLabel(new ImageIcon(
                "D:\\SY Btech IT\\Java Programming\\java mini project\\mini project-java\\src\\jpackage\\image.jpg"));

        f.setContentPane(background);

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);
        l = new JLabel("Welcome to the Online Appointment Booking System");
        l.setBounds(440, 10, 670, 150);
        l.setFont(new Font("Helvetica", Font.BOLD, 26));
        l.setForeground(Color.RED);
        f.add(l);

        l4 = new JLabel("Sign In to your Account");
        l4.setBounds(600, 170, 400, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 26));
        l4.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l4);

        l1 = new JLabel("Enter your Username:");
        l1.setBounds(540, 240, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(765, 240, 200, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Enter your Password:");
        l2.setBounds(540, 320, 225, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundPasswordField(15);
        t2.setBounds(765, 320, 200, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        b1 = new JButton("Login");
        b1.setBounds(700, 415, 120, 35);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Forgot Password");
        b2.setBounds(580, 475, 190, 35);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Create Account");
        b3.setBounds(790, 475, 170, 35);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.addActionListener(this);
        f.add(b3);

        showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(765, 360, 150, 30);
        showpassword.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword.addActionListener(this);
        showpassword.setOpaque(false);
        showpassword.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(showpassword);

        l3 = new JLabel();
        l3.setBounds(590, 120, 500, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        f.add(l3);

        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            String user_name = t1.getText();
            String user_password = t2.getText();

            try {

                String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
                String username_db = "tklsjaddlzcmwj";
                String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                String sql = " SELECT CASE WHEN EXISTS ( SELECT * FROM user_account WHERE user_password=crypt(?,user_password) and username=?) THEN 'TRUEUSER' WHEN EXISTS ( SELECT * FROM admin_account WHERE admin_password=crypt(?,admin_password) and admin_username=?)  THEN 'TRUEADMIN' ELSE 'FALSE' END";

                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, user_password);
                statement.setString(2, user_name);
                statement.setString(3, user_password);
                statement.setString(4, user_name);

                ResultSet a = statement.executeQuery();
                while (a.next()) {
                    String value = a.getString("case");
                    if (value.equals("TRUEUSER")) {
                        user_username = t1.getText();
                        JOptionPane.showMessageDialog(f, "Logged in Successfully");
                        new menu(f, user_username);
                    } else if (value.equals("TRUEADMIN")) {
                        JOptionPane.showMessageDialog(f, "Logged in Successfully as Admin");
                        new admin_menu(f, user_name);

                    } else if (value.equals("FALSE")) {
                        JOptionPane.showMessageDialog(f, "Please Enter a Valid Username or Password");
                    }
                }

                connection.close();
            } catch (SQLException ex) {

                // JOptionPane.showMessageDialog(f, "Failed to connect the servers!! Connection
                // Timed Out");
                JOptionPane.showMessageDialog(f, ex);

            }
        }

        if (e.getSource() == showpassword) {
            if (showpassword.isSelected()) {
                t2.setEchoChar((char) 0);
            } else {
                t2.setEchoChar('\u2022');
            }
        }

        if (e.getSource() == b2) {

            f.getContentPane().removeAll();
            f.repaint();
            new forgotpassword(f);

        }

        if (e.getSource() == b3) {
            new create_account(f);
        }

    }

}

class forgotpassword extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l;
    JButton b1, b2;
    JTextField t1;
    JPasswordField t2, t3;
    JCheckBox showpassword, showpassword1;

    public forgotpassword(JFrame frame) {

        l = new JLabel("Change Password");
        l.setBounds(650, 170, 400, 30);
        l.setFont(new Font("Helvetica", Font.BOLD, 26));
        l.setForeground(Color.red);
        frame.add(l);

        l1 = new JLabel("Enter your Username:");
        l1.setBounds(540, 240, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        frame.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(765, 240, 200, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        frame.add(t1);

        l2 = new JLabel("Enter new Password:");
        l2.setBounds(540, 300, 225, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        frame.add(l2);
        t2 = new RoundPasswordField(15);
        t2.setBounds(765, 300, 200, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        frame.add(t2);

        showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(765, 340, 150, 30);
        showpassword.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword.addActionListener(this);
        showpassword.setOpaque(false);
        showpassword.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        frame.add(showpassword);

        l3 = new JLabel("Confirm new Password:");
        l3.setBounds(540, 390, 225, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        frame.add(l3);
        t3 = new RoundPasswordField(15);
        t3.setBounds(770, 390, 200, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        frame.add(t3);

        showpassword1 = new JCheckBox("Show Password");
        showpassword1.setBounds(765, 430, 150, 30);
        showpassword1.setFont(new Font("Helvetica", Font.BOLD, 14));
        showpassword1.addActionListener(this);
        showpassword1.setOpaque(false);
        showpassword1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        frame.add(showpassword1);

        b1 = new JButton("Reset Password");
        b1.setBounds(540, 480, 200, 35);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        frame.add(b1);

        b2 = new JButton("Go Back To Login");
        b2.setBounds(780, 480, 200, 35);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        frame.add(b2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

        if (e.getSource() == b2) {

            new login();

        }

        if (e.getSource() == b1) {
            String username = t1.getText();
            String user_pasword = t2.getText();
            String confirm_password = t3.getText();
            String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
            String username_db = "tklsjaddlzcmwj";
            String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";
            try {

                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                String sql = "SELECT CASE WHEN EXISTS ( SELECT * FROM user_account WHERE username=?) THEN 'TRUE' ELSE 'FALSE' END";

                PreparedStatement statement1 = connection.prepareStatement(sql);

                statement1.setString(1, username);

                ResultSet data = statement1.executeQuery();

                while (data.next()) {
                    String value = data.getString("case");
                    if (user_pasword.equals(confirm_password)) {
                        if (value.equals("TRUE")) {
                            String sql1 = " update user_account set user_password=crypt(?,user_password) where username=?";
                            PreparedStatement stmt = connection.prepareStatement(sql1);
                            stmt.setString(1, user_pasword);
                            stmt.setString(2, username);
                            stmt.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Password Updated Successfully");
                            new login();

                        } else {
                            JOptionPane.showMessageDialog(null, "No Such Username Exists");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Entered password and Confirm password do not match");
                    }
                }
                connection.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please Enter proper data in Proper Format");
            }

        }
    }
}

public class App {

    public static void main(String[] args) throws Exception {

        new login();

    }

}
