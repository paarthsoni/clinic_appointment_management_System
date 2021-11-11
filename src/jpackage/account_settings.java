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

public class account_settings extends JFrame implements ActionListener, login_user{

    JButton b1, b2, b3;

    public account_settings(JFrame f){
        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        b1 = new JButton("Update Account");
        b1.setBounds(670, 250, 250, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Delete Account");
        b2.setBounds(670, 350, 250, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Go back to Menu");
        b3.setBounds(705, 450, 180, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.addActionListener(this);
        b3.setBackground(Color.RED);
        b3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b3);

        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == b1) {

            new update_account(f);

        }

        if (e.getSource() == b2) {

            new delete_account(f);

        }
        
        if (e.getSource() == b3) {

            new menu(f);

        }
        
    }
}
