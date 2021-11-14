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

public class menu extends JFrame implements ActionListener, login_user {

    JButton b1, b2, b3, b4, b5;
    String user_user_name;

    public menu(JFrame f, String user_username) {

        user_user_name = user_username;
        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        b1 = new JButton("Book an Appointment");
        b1.setBounds(670, 200, 250, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Cancel Appointment");
        b2.setBounds(670, 300, 250, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Show Appointment History");
        b3.setBounds(670, 400, 250, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton("Account Settings");
        b4.setBounds(670, 500, 250, 50);
        b4.setFont(new Font("Helvetica", Font.BOLD, 17));
        b4.addActionListener(this);
        f.add(b4);

        b5 = new JButton("Log Out");
        b5.setBounds(1330, 30, 150, 35);
        b5.setFont(new Font("Helvetica", Font.BOLD, 17));
        b5.addActionListener(this);
        b5.setBackground(Color.RED);
        b5.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            new slot_booking(f, user_user_name);

        }

        if (e.getSource() == b2) {
            new cancel_appointment(f, user_user_name);
        }

        if (e.getSource() == b4) {

            new account_settings(f, user_user_name);

        }

        if (e.getSource() == b5) {

            JOptionPane.showMessageDialog(null, "Logged out Successfully");
            new login();

        }

    }
}
