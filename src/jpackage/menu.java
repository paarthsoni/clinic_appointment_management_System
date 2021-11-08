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

    public menu(JFrame f){
        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        b1 = new JButton("Book an Appointment");
        b1.setBounds(700, 200, 250, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Cancel Appointment");
        b2.setBounds(700, 300, 250, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Show Appointment History");
        b3.setBounds(700, 400, 250, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton("Account Settings");
        b4.setBounds(700, 500, 250, 50);
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
        // TODO Auto-generated method stub

        if (e.getSource() == b1) {

            new slot_booking(f);

        }
        
        if (e.getSource() == b5) {

            new login();

        }
        
    }
}
