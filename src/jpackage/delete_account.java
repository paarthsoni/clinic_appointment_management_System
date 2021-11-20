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

public class delete_account extends JFrame implements ActionListener, login_user {

    JLabel l, l1, l2, l3;
    JButton b1, b2;
    JTextField t1;
    JPasswordField t2;
    JCheckBox showpassword;
    String user_user_name;

    public delete_account(JFrame f, String user_username) {
        user_user_name = user_username;
        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l3 = new JLabel("Delete Your Account");
        l3.setBounds(630, 140, 500, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 26));
        l3.setForeground(Color.RED);
        f.add(l3);

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

        b1 = new JButton("Delete Account");
        b1.setBounds(640, 440, 270, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b1);

        b2 = new JButton("Go back to account Settings");
        b2.setBounds(640, 530, 270, 50);
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
            String delete_username = t1.getText();
            String delete_password = t2.getText();
            String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
            String username_db = "tklsjaddlzcmwj";
            String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";

            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                String delete_check = "SELECT CASE WHEN EXISTS ( SELECT * FROM user_account WHERE username=? and user_password=crypt(?,user_password)) THEN 'TRUEUSER' ELSE 'FALSE' END";

                PreparedStatement statement_delete = connection.prepareStatement(delete_check);

                statement_delete.setString(1, delete_username);
                statement_delete.setString(2, delete_password);

                ResultSet delete_data = statement_delete.executeQuery();

                while (delete_data.next()) {
                    String value = delete_data.getString("case");
                    if (value.equals("TRUEUSER")) {
                        String delete_acc = "delete from user_account where username=?";
                        String delete_acc_his = "delete from appointment_history where user_username=?";
                        PreparedStatement statement_delete_acc = connection.prepareStatement(delete_acc);
                        PreparedStatement statement_delete_acc_his = connection.prepareStatement(delete_acc_his);
                        statement_delete_acc.setString(1, delete_username);
                        statement_delete_acc_his.setString(1, delete_username);

                        statement_delete_acc.executeUpdate();
                        statement_delete_acc_his.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Account Deleted Successfully");
                        new login();

                    } else if (value.equals("FALSE")) {
                        JOptionPane.showMessageDialog(null, "No Such User Present ");
                    }
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Server Error ");
            }

        }

        if (e.getSource() == b2) {

            new account_settings(f, user_user_name);

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
