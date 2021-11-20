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

    public another_admin(JFrame f, String admin_username){
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
        // TODO Auto-generated method stub

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
