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

public class admin_menu extends JFrame implements login_user, ActionListener{
    
    JButton b1, b2, b3, b4;
    String user_user_name;

    public admin_menu(JFrame f, String user_username){
        f.getContentPane().removeAll();
        f.repaint();
        // f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        b1 = new JButton("View Appointments");
        b1.setBounds(670, 250, 250, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Add another admin");
        b2.setBounds(670, 350, 250, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Update Slots");
        b3.setBounds(670, 450, 250, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton("Log Out");
        b4.setBounds(1330, 30, 150, 35);
        b4.setFont(new Font("Helvetica", Font.BOLD, 17));
        b4.addActionListener(this);
        b4.setBackground(Color.RED);
        b4.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == b4) {

            JOptionPane.showMessageDialog(null, "Logged out Successfully");
            new login();

        }
        
    }
}
