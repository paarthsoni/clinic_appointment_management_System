package jpackage;

import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jpackage.*;

interface login_user {
    void login_user();

    static JFrame f = new JFrame("Clinic appointment Management System");
}

// Aayush - Create account class - start

// end

class login extends JFrame implements login_user, ActionListener {
    JLabel l, l1, l2, l3, l4;
    JButton b1, b2, b3;
    JTextField t1;
    JPasswordField t2;
    JCheckBox showpassword;

    public void login_user() {

        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.green);
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
        f.add(l4);

        l1 = new JLabel("Enter your Username:");
        l1.setBounds(540, 240, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
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
        showpassword.setBackground(Color.GREEN);
        showpassword.addActionListener(this);
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
            String jdbcURL = "jdbc:postgresql://localhost:5432/clinic_appointment_management_System";
            String username_db = "postgres";
            String password_db = "paarth@2812";

            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                String sql = " SELECT CASE WHEN EXISTS ( SELECT * FROM user_account WHERE user_password=crypt(?,user_password) and username=?) THEN 'TRUE' ELSE 'FALSE' END";

                String sql1 = " SELECT CASE WHEN EXISTS ( SELECT * FROM admin_account WHERE admin_password=crypt(?,admin_password) and admin_username=?) THEN 'TRUE' ELSE 'FALSE' END";
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, user_password);
                statement.setString(2, user_name);

                PreparedStatement statement1 = connection.prepareStatement(sql);

                statement1.setString(1, user_password);
                statement1.setString(2, user_name);

                ResultSet b = statement1.executeQuery();

                ResultSet a = statement.executeQuery();
                while (a.next()) {
                    String value = a.getString("case");
                    if (value.equals("TRUE")) {
                        JOptionPane.showMessageDialog(f, "Logged in Successfully");
                    } else if (value.equals("FALSE")) {
                        JOptionPane.showMessageDialog(f, "Please Enter a Valid Password or username");
                    }
                }

                while (b.next()) {
                    String value = b.getString("case");
                    if (value.equals("TRUE")) {
                        JOptionPane.showMessageDialog(f, "Logged in Successfully as admin");
                    } else if (value.equals("FALSE")) {
                        JOptionPane.showMessageDialog(f, "Please Enter a Valid Password or username");
                    }

                }

                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(f, "Failed to connect the servers!! Connection Timed Out" + "-" + ex);

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
            forgotpassword forgot = new forgotpassword(f);

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
        showpassword.setBackground(Color.GREEN);
        showpassword.addActionListener(this);
        frame.add(showpassword);

        l3 = new JLabel("Confirm new Password:");
        l3.setBounds(540, 390, 225, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
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
        showpassword1.setBackground(Color.GREEN);
        showpassword1.addActionListener(this);
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

            login obj = new login();
            obj.login_user();

        }

        if (e.getSource() == b1) {
            String username = t1.getText();
            String user_pasword = t2.getText();
            String confirm_password = t3.getText();
            String jdbcURL = "jdbc:postgresql://localhost:5432/clinic_appointment_management_System";
            String username_db = "postgres";
            String password_db = "paarth@2812";

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
                            JOptionPane.showMessageDialog(null, "Successfully Updated Password");

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

        login user = new login();
        user.login_user();

    }
}
