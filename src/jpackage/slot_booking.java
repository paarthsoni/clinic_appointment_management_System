package jpackage;

import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URISyntaxException;

import jpackage.*;

public class slot_booking extends JFrame implements ActionListener , login_user {

    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JRadioButton male, female, other;

    public slot_booking(JFrame f){
        f.getContentPane().removeAll();
        f.repaint();
        f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l1 = new JLabel("Patient's First Name:");
        l1.setBounds(65, 50, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(50, 90, 225, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Patient's Last Name:");
        l2.setBounds(335, 50, 225, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundJTextField(15);
        t2.setBounds(320, 90, 225, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        l3 = new JLabel("Date of Birth:");
        l3.setBounds(250, 130, 225, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);
        // UtilDateModel model = new UtilDateModel();
        // JDatePanelImpl datePanel = new JDatePanelImpl(model, null);
        // JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
        // f.add(datePicker);
        t3 = new RoundJTextField(15);
        t3.setBounds(50, 170, 500, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t3);

        l4 = new JLabel("Gender:");
        l4.setBounds(50, 230, 225, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 20));
        l4.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l4);
        male = new JRadioButton("Male");
        male.setBounds(200, 230, 100, 30);
        male.setFont(new Font("Helvetica", Font.BOLD, 20));
        male.addActionListener(this);
        male.setOpaque(false);
        male.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(male);
        female = new JRadioButton("Female");
        female.setBounds(320, 230, 130, 30);
        female.setFont(new Font("Helvetica", Font.BOLD, 20));
        female.addActionListener(this);
        female.setOpaque(false);
        female.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(female);
        other = new JRadioButton("Other");
        other.setBounds(470, 230, 150, 30);
        other.setFont(new Font("Helvetica", Font.BOLD, 20));
        other.addActionListener(this);
        other.setOpaque(false);
        other.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(other);

        l5 = new JLabel("Date of Appointment:");
        l5.setBounds(200, 300, 225, 30);
        l5.setFont(new Font("Helvetica", Font.BOLD, 20));
        l5.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l5);
        t4 = new RoundJTextField(15);
        t4.setBounds(50, 340, 500, 30);
        t4.setBackground(Color.white);
        t4.setForeground(Color.black);
        t4.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t4);

        l6 = new JLabel("Time of Appointment:");
        l6.setBounds(200, 380, 225, 30);
        l6.setFont(new Font("Helvetica", Font.BOLD, 20));
        l6.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l6);
        t5 = new RoundJTextField(15);
        t5.setBounds(50, 420, 500, 30);
        t5.setBackground(Color.white);
        t5.setForeground(Color.black);
        t5.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t5);

        l7 = new JLabel("Phone Number:");
        l7.setBounds(220, 460, 225, 30);
        l7.setFont(new Font("Helvetica", Font.BOLD, 20));
        l7.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l7);
        t6 = new RoundJTextField(15);
        t6.setBounds(50, 500, 500, 30);
        t6.setBackground(Color.white);
        t6.setForeground(Color.black);
        t6.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t6);

        l8 = new JLabel("Patient's Problem:");
        l8.setBounds(210, 540, 225, 30);
        l8.setFont(new Font("Helvetica", Font.BOLD, 20));
        l8.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l8);
        t7 = new RoundJTextField(15);
        t7.setBounds(50, 580, 500, 170);
        t7.setBackground(Color.white);
        t7.setForeground(Color.black);
        t7.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t7);

        l9 = new JLabel("Morning Slots:");
        l9.setBounds(1000, 50, 225, 30);
        l9.setFont(new Font("Helvetica", Font.BOLD, 20));
        l9.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l9);

        b19 = new JButton("Refresh");
        b19.setBounds(1300, 20, 180, 40);
        b19.setFont(new Font("Helvetica", Font.BOLD, 17));
        b19.addActionListener(this);
        f.add(b19);

        b1 = new JButton("9:00 - 9:30");
        b1.setBounds(700, 100, 250, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("9:30 - 10:00");
        b2.setBounds(980, 100, 250, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("10:00 - 10:30");
        b3.setBounds(1260, 100, 250, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton("10:30 - 11:00");
        b4.setBounds(700, 170, 250, 50);
        b4.setFont(new Font("Helvetica", Font.BOLD, 17));
        b4.addActionListener(this);
        f.add(b4);

        b5 = new JButton("11:00 - 11:30");
        b5.setBounds(980, 170, 250, 50);
        b5.setFont(new Font("Helvetica", Font.BOLD, 17));
        b5.addActionListener(this);
        f.add(b5);

        b6 = new JButton("11:30 - 12:00");
        b6.setBounds(1260, 170, 250, 50);
        b6.setFont(new Font("Helvetica", Font.BOLD, 17));
        b6.addActionListener(this);
        f.add(b6);

        b7 = new JButton("12:00 - 12:30");
        b7.setBounds(700, 240, 250, 50);
        b7.setFont(new Font("Helvetica", Font.BOLD, 17));
        b7.addActionListener(this);
        f.add(b7);

        b8 = new JButton("12:30 - 01:00");
        b8.setBounds(980, 240, 250, 50);
        b8.setFont(new Font("Helvetica", Font.BOLD, 17));
        b8.addActionListener(this);
        f.add(b8);

        l9 = new JLabel("Evening Slots:");
        l9.setBounds(1000, 350, 250, 30);
        l9.setFont(new Font("Helvetica", Font.BOLD, 20));
        l9.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l9);

        b9 = new JButton("5:00 - 5:30");
        b9.setBounds(700, 400, 250, 50);
        b9.setFont(new Font("Helvetica", Font.BOLD, 17));
        b9.addActionListener(this);
        f.add(b9);

        b10 = new JButton("5:30 - 6:00");
        b10.setBounds(980, 400, 250, 50);
        b10.setFont(new Font("Helvetica", Font.BOLD, 17));
        b10.addActionListener(this);
        f.add(b10);

        b11 = new JButton("6:00 - 6:30");
        b11.setBounds(1260, 400, 250, 50);
        b11.setFont(new Font("Helvetica", Font.BOLD, 17));
        b11.addActionListener(this);
        f.add(b11);

        b12 = new JButton("6:30 - 7:00");
        b12.setBounds(700, 470, 250, 50);
        b12.setFont(new Font("Helvetica", Font.BOLD, 17));
        b12.addActionListener(this);
        f.add(b12);

        b13 = new JButton("7:00 - 7:30");
        b13.setBounds(980, 470, 250, 50);
        b13.setFont(new Font("Helvetica", Font.BOLD, 17));
        b13.addActionListener(this);
        f.add(b13);

        b14 = new JButton("7:30 - 8:00");
        b14.setBounds(1260, 470, 250, 50);
        b14.setFont(new Font("Helvetica", Font.BOLD, 17));
        b14.addActionListener(this);
        f.add(b14);

        b15 = new JButton("8:00 - 8:30");
        b15.setBounds(700, 540, 250, 50);
        b15.setFont(new Font("Helvetica", Font.BOLD, 17));
        b15.addActionListener(this);
        f.add(b15);

        b16 = new JButton("8:30 - 9:00");
        b16.setBounds(980, 540, 250, 50);
        b16.setFont(new Font("Helvetica", Font.BOLD, 17));
        b16.addActionListener(this);
        f.add(b16);

        b17 = new JButton("Go Back to Menu");
        b17.setBounds(980, 700, 250, 50);
        b17.setFont(new Font("Helvetica", Font.BOLD, 17));
        b17.addActionListener(this);
        b17.setBackground(Color.RED);
        b17.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b17);

        b18 = new JButton("Confirm Booking");
        b18.setBounds(1260, 700, 250, 50);
        b18.setFont(new Font("Helvetica", Font.BOLD, 17));
        b18.addActionListener(this);
        b18.setBackground(Color.GREEN);
        b18.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(b18);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == b17) {

            new menu(f);

        }
    }
    
}
