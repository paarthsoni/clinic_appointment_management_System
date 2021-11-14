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

public class appointment_history extends JFrame implements ActionListener, login_user {

    String user_user_name;
    JTable t1;
    JFrame f1;
    JLabel l;

    public appointment_history(JFrame f , String user_username){
        user_user_name = user_username;
        // f.getContentPane().removeAll();
        // f.repaint();
        // f.getContentPane().setBackground(Color.green);
        // f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // f.setDefaultLookAndFeelDecorated(true);


        f1 = new JFrame("Appointment History");

        Object data[][] = {{"a", "a", "a", "a", "a", "a", "a", "a"}};
        
        String columnNames[] ={"Patient firstname", "Patient lastname", "Age", "Gender", "Appointment date", "Appointment time", "Contact num", "Patient Problem"};

        t1 = new JTable(data , columnNames);
        t1.setBounds(30,40,1500,700);
        JScrollPane sp=new JScrollPane(t1);    
        f1.add(sp); 
        
        f1.getContentPane().setBackground(Color.green);
        f1.setSize(500,500);
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setDefaultLookAndFeelDecorated(true);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
           
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}


