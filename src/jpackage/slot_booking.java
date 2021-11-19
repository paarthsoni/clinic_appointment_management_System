package jpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.TableModel;

public class slot_booking extends JFrame implements ActionListener, login_user {

    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JRadioButton male, female, other;
    JTextArea a1;
    String user_user_name;

    public slot_booking(JFrame f, String user_username) {

        user_user_name = user_username;
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

        l3 = new JLabel("Patient's Age:");
        l3.setBounds(250, 130, 225, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);

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
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        t4.setText(strDate);
        t4.setForeground(Color.black);
        t4.setFont(new Font("Helvetica", Font.BOLD, 15));
        t4.setEditable(false);
        f.add(t4);

        l6 = new JLabel("Slot of Appointment:");
        l6.setBounds(200, 380, 225, 30);
        l6.setFont(new Font("Helvetica", Font.BOLD, 20));
        l6.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l6);
        t5 = new RoundJTextField(15);
        t5.setBounds(50, 420, 500, 30);
        t5.setBackground(Color.white);
        t5.setForeground(Color.black);
        t5.setFont(new Font("Helvetica", Font.BOLD, 15));
        t5.setText("Your Time Slot will be displayed here");
        t5.setEditable(false);
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

        l8 = new JLabel("Patient's Problem (Optional):");
        l8.setBounds(160, 540, 310, 30);
        l8.setFont(new Font("Helvetica", Font.BOLD, 20));
        l8.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l8);
        a1 = new RoundJTextArea();
        a1.setBounds(50, 580, 500, 170);
        a1.setBackground(Color.white);
        a1.setForeground(Color.black);
        a1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(a1);

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

        b1 = new JButton();
        b1.setBounds(700, 100, 250, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton();
        b2.setBounds(980, 100, 250, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton();
        b3.setBounds(1260, 100, 250, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton();
        b4.setBounds(700, 170, 250, 50);
        b4.setFont(new Font("Helvetica", Font.BOLD, 17));
        b4.addActionListener(this);
        f.add(b4);

        b5 = new JButton();
        b5.setBounds(980, 170, 250, 50);
        b5.setFont(new Font("Helvetica", Font.BOLD, 17));
        b5.addActionListener(this);
        f.add(b5);

        b6 = new JButton();
        b6.setBounds(1260, 170, 250, 50);
        b6.setFont(new Font("Helvetica", Font.BOLD, 17));
        b6.addActionListener(this);
        f.add(b6);

        b7 = new JButton();
        b7.setBounds(700, 240, 250, 50);
        b7.setFont(new Font("Helvetica", Font.BOLD, 17));
        b7.addActionListener(this);
        f.add(b7);

        b8 = new JButton();
        b8.setBounds(980, 240, 250, 50);
        b8.setFont(new Font("Helvetica", Font.BOLD, 17));
        b8.addActionListener(this);
        f.add(b8);

        l9 = new JLabel("Evening Slots:");
        l9.setBounds(1000, 350, 250, 30);
        l9.setFont(new Font("Helvetica", Font.BOLD, 20));
        l9.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l9);

        b9 = new JButton();
        b9.setBounds(700, 400, 250, 50);
        b9.setFont(new Font("Helvetica", Font.BOLD, 17));
        b9.addActionListener(this);
        f.add(b9);

        b10 = new JButton();
        b10.setBounds(980, 400, 250, 50);
        b10.setFont(new Font("Helvetica", Font.BOLD, 17));
        b10.addActionListener(this);
        f.add(b10);

        b11 = new JButton();
        b11.setBounds(1260, 400, 250, 50);
        b11.setFont(new Font("Helvetica", Font.BOLD, 17));
        b11.addActionListener(this);
        f.add(b11);

        b12 = new JButton();
        b12.setBounds(700, 470, 250, 50);
        b12.setFont(new Font("Helvetica", Font.BOLD, 17));
        b12.addActionListener(this);
        f.add(b12);

        b13 = new JButton();
        b13.setBounds(980, 470, 250, 50);
        b13.setFont(new Font("Helvetica", Font.BOLD, 17));
        b13.addActionListener(this);
        f.add(b13);

        b14 = new JButton();
        b14.setBounds(1260, 470, 250, 50);
        b14.setFont(new Font("Helvetica", Font.BOLD, 17));
        b14.addActionListener(this);
        f.add(b14);

        b15 = new JButton();
        b15.setBounds(700, 540, 250, 50);
        b15.setFont(new Font("Helvetica", Font.BOLD, 17));
        b15.addActionListener(this);
        f.add(b15);

        b16 = new JButton();
        b16.setBounds(980, 540, 250, 50);
        b16.setFont(new Font("Helvetica", Font.BOLD, 17));
        b16.addActionListener(this);
        f.add(b16);

        String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
        String username_db = "tklsjaddlzcmwj";
        String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";
        try {

            Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);
            String sql = "select slots_available from slots where slot_timing='9:00 - 9:30' ";
            Statement statement1 = connection.createStatement();

            ResultSet a = statement1.executeQuery(sql);

            while (a.next()) {
                int value = a.getInt("slots_available");
                if (value == 0) {
                    b1.setBackground(Color.red);
                    b1.setText("9:00 - 9:30" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b1.repaint();
                    b1.setEnabled(false);
                } else {
                    b1.setBackground(Color.green);
                    b1.setText("9:00 - 9:30" + "   " + "(" + value + ")");
                }

            }

            String id = TimeZone.getDefault().getID();

            ZoneId zoneId = ZoneId.of(id);
            ZonedDateTime now = ZonedDateTime.now(zoneId);
            ZonedDateTime startOfDay = now.toLocalDate().atStartOfDay(zoneId);
            Duration duration = Duration.between(startOfDay, now);
            long minutesIntoTheDay = duration.toMinutes();

            Date date1 = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH");
            String hour = sdf.format(date1);
            SimpleDateFormat sdf1 = new SimpleDateFormat("mm");
            String min = sdf1.format(date1);
            int hours = Integer.parseInt(hour);

            int mins = Integer.parseInt(min);

            if (hours >= 9 && minutesIntoTheDay >= 571) {
                String disable1 = "update slots set slots_available=0 where slot_timing='9:00 - 9:30'";
                Statement d_stmt1 = connection.createStatement();

                d_stmt1.executeUpdate(disable1);

                String sql_1 = "select slots_available from slots where slot_timing='9:00 - 9:30' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b1.setBackground(Color.red);
                    b1.setText("9:00 - 9:30" + " " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b1.setEnabled(false);

                }

            }

            String sql1 = "select slots_available from slots where slot_timing='9:30 - 10:00' ";
            Statement statement2 = connection.createStatement();

            ResultSet b = statement2.executeQuery(sql1);

            while (b.next()) {
                int value1 = b.getInt("slots_available");
                if (value1 == 0) {
                    b2.setBackground(Color.red);
                    b2.setText("9:30 - 10:00" + "   " + "(" + value1 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b2.repaint();
                    b2.setEnabled(false);
                } else {
                    b2.setBackground(Color.green);
                    b2.setText("9:30 - 10:00" + "   " + "(" + value1 + ")");
                }

            }

            if (hours >= 10 && minutesIntoTheDay >= 601) {
                String disable2 = "update slots set slots_available=0 where slot_timing='9:30 - 10:00'";
                Statement d_stmt2 = connection.createStatement();

                d_stmt2.executeUpdate(disable2);

                String sql_1 = "select slots_available from slots where slot_timing='9:30 - 10:00' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b2.setBackground(Color.red);
                    b2.setText("9:30 - 10:00" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b2.setEnabled(false);
                }

            }

            String sql2 = "select slots_available from slots where slot_timing='10:00 - 10:30' ";
            Statement statement3 = connection.createStatement();

            ResultSet c = statement3.executeQuery(sql2);

            while (c.next()) {
                int value2 = c.getInt("slots_available");
                if (value2 == 0) {
                    b3.setBackground(Color.red);
                    b3.setText("10:00 - 10:30" + "   " + "(" + value2 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b3.repaint();
                    b3.setEnabled(false);
                } else {
                    b3.setBackground(Color.green);
                    b3.setText("10:00 - 10:30" + "   " + "(" + value2 + ")");
                }

            }

            if (hours >= 10 && minutesIntoTheDay >= 631) {
                String disable3 = "update slots set slots_available=0 where slot_timing='10:00 - 10:30'";
                Statement d_stmt3 = connection.createStatement();

                d_stmt3.executeUpdate(disable3);

                String sql_1 = "select slots_available from slots where slot_timing='10:00 - 10:30' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b3.setBackground(Color.red);
                    b3.setText("10:00 - 10:30" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b3.setEnabled(false);
                }

            }

            String sql3 = "select slots_available from slots where slot_timing='10:30 - 11:00' ";
            Statement statement4 = connection.createStatement();

            ResultSet d = statement4.executeQuery(sql3);

            while (d.next()) {
                int value3 = d.getInt("slots_available");
                if (value3 == 0) {
                    b4.setBackground(Color.red);
                    b4.setText("10:30 - 11:00" + " " + "(" + value3 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b4.repaint();
                    b4.setEnabled(false);
                } else {
                    b4.setBackground(Color.green);
                    b4.setText("10:30 - 11:00" + " " + "(" + value3 + ")");
                }

            }

            if (hours >= 11 && minutesIntoTheDay >= 661) {
                String disable4 = "update slots set slots_available=0 where slot_timing='10:30 - 11:00'";
                Statement d_stmt4 = connection.createStatement();

                d_stmt4.executeUpdate(disable4);

                String sql_1 = "select slots_available from slots where slot_timing='10:30 - 11:00' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b4.setBackground(Color.red);
                    b4.setText("10:30 - 11:00" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b4.setEnabled(false);
                }

            }

            String sql4 = "select slots_available from slots where slot_timing='11:00 - 11:30' ";
            Statement statement5 = connection.createStatement();

            ResultSet e = statement5.executeQuery(sql4);

            while (e.next()) {
                int value4 = e.getInt("slots_available");
                if (value4 == 0) {
                    b5.setBackground(Color.red);
                    b5.setText("11:00 - 11:30" + " " + "(" + value4 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b5.repaint();
                    b5.setEnabled(false);
                } else {
                    b5.setBackground(Color.green);
                    b5.setText("11:00 - 11:30" + " " + "(" + value4 + ")");
                }

            }

            if (hours >= 11 && minutesIntoTheDay >= 691) {
                String disable5 = "update slots set slots_available=0 where slot_timing='11:00 - 11:30'";
                Statement d_stmt5 = connection.createStatement();

                d_stmt5.executeUpdate(disable5);

                String sql_1 = "select slots_available from slots where slot_timing='11:00 - 11:30' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b5.setBackground(Color.red);
                    b5.setText("11:00 - 11:30" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b5.setEnabled(false);
                }

            }

            String sql5 = "select slots_available from slots where slot_timing='11:30 - 12:00' ";
            Statement statement6 = connection.createStatement();

            ResultSet g = statement6.executeQuery(sql5);

            while (g.next()) {
                int value5 = g.getInt("slots_available");
                if (value5 == 0) {
                    b6.setBackground(Color.red);
                    b6.setText("11:30 - 12:00" + " " + "(" + value5 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b6.repaint();
                    b6.setEnabled(false);
                } else {
                    b6.setBackground(Color.green);
                    b6.setText("11:30 - 12:00" + " " + "(" + value5 + ")");
                }

            }

            if (hours >= 12 && minutesIntoTheDay >= 721) {
                String disable6 = "update slots set slots_available=0 where slot_timing='11:30 - 12:00'";
                Statement d_stmt6 = connection.createStatement();

                d_stmt6.executeUpdate(disable6);

                String sql_1 = "select slots_available from slots where slot_timing='11:30 - 12:00' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b6.setBackground(Color.red);
                    b6.setText("11:30 - 12:00" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b6.setEnabled(false);
                }
            }

            String sql6 = "select slots_available from slots where slot_timing='12:00 - 12:30' ";
            Statement statement7 = connection.createStatement();

            ResultSet h = statement7.executeQuery(sql6);

            while (h.next()) {
                int value6 = h.getInt("slots_available");
                if (value6 == 0) {
                    b7.setBackground(Color.red);
                    b7.setText("12:00 - 12:30" + " " + "(" + value6 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b7.repaint();
                    b7.setEnabled(false);
                } else {
                    b7.setBackground(Color.green);
                    b7.setText("12:00 - 12:30" + " " + "(" + value6 + ")");
                }

                if (hours >= 12 && minutesIntoTheDay >= 751) {
                    String disable7 = "update slots set slots_available=0 where slot_timing='12:00 - 12:30'";
                    Statement d_stmt7 = connection.createStatement();

                    d_stmt7.executeUpdate(disable7);

                    String sql_1 = "select slots_available from slots where slot_timing='12:00 - 12:30' ";
                    Statement statement_1 = connection.createStatement();

                    ResultSet a1 = statement_1.executeQuery(sql_1);

                    while (a1.next()) {
                        int value = a1.getInt("slots_available");
                        b7.setBackground(Color.red);
                        b7.setText("12:00 - 12:30" + "   " + "(" + value + ")");
                        UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                        b7.setEnabled(false);
                    }

                }

                String sql7 = "select slots_available from slots where slot_timing='12:30 - 1:00' ";
                Statement statement8 = connection.createStatement();

                ResultSet i = statement8.executeQuery(sql7);

                while (i.next()) {
                    int value7 = i.getInt("slots_available");
                    if (value7 == 0) {
                        b8.setBackground(Color.red);
                        b8.setText("12:30 - 1:00" + " " + "(" + value7 + ")");
                        UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                        b8.repaint();
                        b8.setEnabled(false);
                    } else {
                        b8.setBackground(Color.green);
                        b8.setText("12:30 - 1:00" + " " + "(" + value7 + ")");
                    }

                }

            }

            if (hours >= 13 && minutesIntoTheDay >= 781) {
                String disable8 = "update slots set slots_available=0 where slot_timing='12:30 - 1:00'";
                Statement d_stmt8 = connection.createStatement();

                d_stmt8.executeUpdate(disable8);

                String sql_1 = "select slots_available from slots where slot_timing='12:30 - 1:00' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b8.setBackground(Color.red);
                    b8.setText("12:30 - 1:00" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b8.setEnabled(false);
                }

            }

            String sql8 = "select slots_available from slots where slot_timing='5:00 - 5:30' ";
            Statement statement9 = connection.createStatement();

            ResultSet j = statement9.executeQuery(sql8);

            while (j.next()) {
                int value8 = j.getInt("slots_available");
                if (value8 == 0) {
                    b9.setBackground(Color.red);
                    b9.setText("5:00 - 5:30" + " " + "(" + value8 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));

                    b9.setEnabled(false);
                } else {
                    b9.setBackground(Color.green);
                    b9.setText("5:00 - 5:30" + " " + "(" + value8 + ")");
                }

            }

            if (hours >= 17 && minutesIntoTheDay >= 1051) {
                String disable1 = "update slots set slots_available=0 where slot_timing='5:00 - 5:30'";
                Statement d_stmt1 = connection.createStatement();

                d_stmt1.executeUpdate(disable1);

                String sql_1 = "select slots_available from slots where slot_timing='5:00 - 5:30' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b9.setBackground(Color.red);
                    b9.setText("5:00 - 5:30" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b9.setEnabled(false);
                }

            }

            String sql9 = "select slots_available from slots where slot_timing='5:30 - 6:00' ";
            Statement statement10 = connection.createStatement();

            ResultSet k = statement10.executeQuery(sql9);

            while (k.next()) {
                int value9 = k.getInt("slots_available");
                if (value9 == 0) {
                    b10.setBackground(Color.red);
                    b10.setText("5:30 - 6:00" + " " + "(" + value9 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b10.repaint();
                    b10.setEnabled(false);
                } else {
                    b10.setBackground(Color.green);
                    b10.setText("5:30 - 6:00" + " " + "(" + value9 + ")");
                }

            }

            if (hours >= 18 && minutesIntoTheDay >= 1081) {
                String disable1 = "update slots set slots_available=0 where slot_timing='5:30 - 6:00'";
                Statement d_stmt1 = connection.createStatement();

                d_stmt1.executeUpdate(disable1);

                String sql_1 = "select slots_available from slots where slot_timing='5:30 - 6:00' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b10.setBackground(Color.red);
                    b10.setText("5:30 - 6:00" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b10.setEnabled(false);
                }

            }

            String sql10 = "select slots_available from slots where slot_timing='6:00 - 6:30' ";
            Statement statement11 = connection.createStatement();

            ResultSet l = statement11.executeQuery(sql10);

            while (l.next()) {
                int value10 = l.getInt("slots_available");
                if (value10 == 0) {
                    b11.setBackground(Color.red);
                    b11.setText("6:00 - 6:30" + " " + "(" + value10 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b11.repaint();
                    b11.setEnabled(false);
                } else {
                    b11.setBackground(Color.green);
                    b11.setText("6:00 - 6:30" + " " + "(" + value10 + ")");
                }

            }

            if (hours >= 18 && minutesIntoTheDay >= 1111) {
                String disable1 = "update slots set slots_available=0 where slot_timing='6:00 - 6:30'";
                Statement d_stmt1 = connection.createStatement();

                String sql_1 = "select slots_available from slots where slot_timing='6:00 - 6:30' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b11.setBackground(Color.red);
                    b11.setText("6:00 - 6:30" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b11.setEnabled(false);
                }

                d_stmt1.executeUpdate(disable1);

            }

            String sql11 = "select slots_available from slots where slot_timing='6:30 - 7:00' ";
            Statement statement12 = connection.createStatement();

            ResultSet m = statement12.executeQuery(sql11);

            while (m.next()) {
                int value11 = m.getInt("slots_available");
                if (value11 == 0) {
                    b12.setBackground(Color.red);
                    b12.setText("6:30 - 7:00" + " " + "(" + value11 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b12.repaint();
                    b12.setEnabled(false);
                } else {
                    b12.setBackground(Color.green);
                    b12.setText("6:30 - 7:00" + " " + "(" + value11 + ")");
                }

            }

            if (hours >= 19 && minutesIntoTheDay >= 1141) {
                String disable1 = "update slots set slots_available=0 where slot_timing='6:30 - 7:00'";
                Statement d_stmt1 = connection.createStatement();

                d_stmt1.executeUpdate(disable1);

                String sql_1 = "select slots_available from slots where slot_timing='6:30 - 7:00' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b12.setBackground(Color.red);
                    b12.setText("6:30 - 7:00" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b12.setEnabled(false);
                }

            }

            String sql12 = "select slots_available from slots where slot_timing='7:00 - 7:30' ";
            Statement statement13 = connection.createStatement();

            ResultSet n = statement13.executeQuery(sql12);

            while (n.next()) {
                int value12 = n.getInt("slots_available");
                if (value12 == 0) {
                    b13.setBackground(Color.red);
                    b13.setText("7:00 - 7:30" + " " + "(" + value12 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b13.repaint();
                    b13.setEnabled(false);
                } else {
                    b13.setBackground(Color.green);
                    b13.setText("7:00 - 7:30" + " " + "(" + value12 + ")");
                }

            }

            if (hours >= 19 && minutesIntoTheDay >= 1171) {
                String disable1 = "update slots set slots_available=0 where slot_timing='7:00 - 7:30'";
                Statement d_stmt1 = connection.createStatement();

                d_stmt1.executeUpdate(disable1);

                String sql_1 = "select slots_available from slots where slot_timing='7:00 - 7:30' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b13.setBackground(Color.red);
                    b13.setText("7:00 - 7:30" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b13.setEnabled(false);
                }

            }

            String sql13 = "select slots_available from slots where slot_timing='7:30 - 8:00' ";
            Statement statement14 = connection.createStatement();

            ResultSet o = statement14.executeQuery(sql13);

            while (o.next()) {
                int value13 = o.getInt("slots_available");
                if (value13 == 0) {
                    b14.setBackground(Color.red);
                    b14.setText("7:30 - 8:00" + " " + "(" + value13 + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b14.repaint();
                    b14.setEnabled(false);
                } else {
                    b14.setBackground(Color.green);
                    b14.setText("7:30 - 8:00" + " " + "(" + value13 + ")");
                }

            }

            if (hours >= 20 && minutesIntoTheDay >= 1201) {
                String disable1 = "update slots set slots_available=0 where slot_timing='7:30 - 8:00'";
                Statement d_stmt1 = connection.createStatement();

                d_stmt1.executeUpdate(disable1);

                String sql_1 = "select slots_available from slots where slot_timing='7:30 - 8:00' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b14.setBackground(Color.red);
                    b14.setText("7:30 - 8:00" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b14.setEnabled(false);
                }

            }

            String sql14 = "select slots_available from slots where slot_timing='8:00 - 8:30' ";
            Statement statement15 = connection.createStatement();

            ResultSet p = statement15.executeQuery(sql14);

            while (p.next()) {
                int value = p.getInt("slots_available");
                if (value == 0) {
                    b15.setBackground(Color.red);
                    b15.setText("8:00 - 8:30" + " " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b15.repaint();
                    b15.setEnabled(false);
                } else {
                    b15.setBackground(Color.green);
                    b15.setText("8:00 - 8:30" + " " + "(" + value + ")");
                }

            }

            if (hours >= 20 && minutesIntoTheDay >= 1231) {
                String disable1 = "update slots set slots_available=0 where slot_timing='8:00 - 8:30'";
                Statement d_stmt1 = connection.createStatement();

                d_stmt1.executeUpdate(disable1);

                String sql_1 = "select slots_available from slots where slot_timing='8:00 - 8:30' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b15.setBackground(Color.red);
                    b15.setText("8:00 - 8:30" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b15.setEnabled(false);

                }

            }

            String sql15 = "select slots_available from slots where slot_timing='8:30 - 9:00' ";
            Statement statement16 = connection.createStatement();

            ResultSet q = statement16.executeQuery(sql15);

            while (q.next()) {
                int value = q.getInt("slots_available");
                if (value == 0) {
                    b16.setBackground(Color.red);
                    b16.setText("8:30 - 9:00" + " " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b16.repaint();
                    b16.setEnabled(false);
                } else {
                    b16.setBackground(Color.green);
                    b16.setText("8:30 - 9:00" + " " + "(" + value + ")");
                }

            }

            if (hours >= 21 && minutesIntoTheDay >= 1261) {
                String disable1 = "update slots set slots_available=0 where slot_timing='8:30 - 9:00'";
                Statement d_stmt1 = connection.createStatement();

                d_stmt1.executeUpdate(disable1);

                String sql_1 = "select slots_available from slots where slot_timing='8:30 - 9:00' ";
                Statement statement_1 = connection.createStatement();

                ResultSet a1 = statement_1.executeQuery(sql_1);

                while (a1.next()) {
                    int value = a1.getInt("slots_available");
                    b16.setBackground(Color.red);
                    b16.setText("8:30 - 9:00" + "   " + "(" + value + ")");
                    UIManager.put("Button.disabledText", new ColorUIResource(Color.black));
                    b16.setEnabled(false);
                }

            }

            connection.close();
        }

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

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

        if (e.getSource() == b1) {
            t5.setText("9:00 - 9:30");
            t5.setEditable(false);

        }

        if (e.getSource() == b2) {
            t5.setText("9:30 - 10:00");
            t5.setEditable(false);

        }
        if (e.getSource() == b3) {
            t5.setText("10:00 - 10:30");
            t5.setEditable(false);

        }
        if (e.getSource() == b4) {
            t5.setText("10:30 - 11:00");
            t5.setEditable(false);

        }
        if (e.getSource() == b5) {
            t5.setText("11:00 - 11:30");
            t5.setEditable(false);

        }
        if (e.getSource() == b6) {
            t5.setText("11:30 - 12:00");
            t5.setEditable(false);

        }
        if (e.getSource() == b7) {
            t5.setText("12:00 - 12:30");
            t5.setEditable(false);

        }
        if (e.getSource() == b8) {
            t5.setText("12:30 - 1:00");
            t5.setEditable(false);

        }
        if (e.getSource() == b9) {
            t5.setText("5:00 - 5:30");
            t5.setEditable(false);

        }
        if (e.getSource() == b10) {
            t5.setText("5:30 - 6:00");
            t5.setEditable(false);

        }
        if (e.getSource() == b11) {
            t5.setText("6:00 - 6:30");
            t5.setEditable(false);

        }
        if (e.getSource() == b12) {
            t5.setText("6:30 - 7:00");
            t5.setEditable(false);

        }
        if (e.getSource() == b13) {
            t5.setText("7:00 - 7:30");
            t5.setEditable(false);

        }
        if (e.getSource() == b14) {
            t5.setText("7:30 - 8:00");
            t5.setEditable(false);

        }
        if (e.getSource() == b15) {
            t5.setText("8:00 - 8:30");
            t5.setEditable(false);

        }
        if (e.getSource() == b16) {
            t5.setText("8:30 - 9:00");
            t5.setEditable(false);

        }
        if (e.getSource() == b17) {

            new menu(f, user_user_name);

        }

        if (e.getSource() == b18) {

            String p_fname = t1.getText();
            String p_lname = t2.getText();
            String age = t3.getText();
            String gender;
            if (male.isSelected()) {
                gender = male.getText();

            } else if (female.isSelected()) {
                gender = female.getText();
            } else if (other.isSelected()) {
                gender = other.getText();
            } else {
                gender = "";
            }
            String apdate = t4.getText();
            String aptime = t5.getText();
            String contact = t6.getText();
            String patient_problem = a1.getText();

            String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
            String username_db = "tklsjaddlzcmwj";
            String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";

            boolean data = p_fname.matches("[a-zA-Z]+");
            boolean data1 = p_lname.matches("[a-zA-Z]+");
            boolean data2 = age.matches("[0-9]+");
            boolean data3 = contact.matches("[0-9]+");

            if ((!t1.getText().equals("")) && (!t2.getText().equals("")) && (!t3.getText().equals(""))
                    && (!t4.getText().equals("")) && (!t5.getText().equals("")) && (!t6.getText().equals(""))) {
                if (((data) && (data1) && (data2) && (data3) && contact.length() == 10 && male.isSelected()
                        || female.isSelected() || other.isSelected())
                        && (!aptime.equals("Your Time Slot will be displayed here"))) {

                    try {
                        Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                        String sql_check = "select slots_available from slots where slot_timing=?";
                        PreparedStatement stmt_check = connection.prepareStatement(sql_check);

                        stmt_check.setString(1, aptime);

                        ResultSet slot_check = stmt_check.executeQuery();

                        while (slot_check.next()) {
                            int data_check = slot_check.getInt("slots_available");

                            if (data_check != 0) {
                                String sql_book = "insert into appointments(p_fname,p_lname,age_of_patient,gender,date_of_appointment,time_of_appointment,contact_num,patient_problem,user_username) values(?,?,?,?,?,?,?,?,?)";

                                String app_history = "insert into appointment_history(p_fname,p_lname,age,gender,appointment_date,appointment_time,contact_num,patient_problem,user_username) values(?,?,?,?,?,?,?,?,?)";
                                PreparedStatement stmt_book = connection.prepareStatement(sql_book);

                                stmt_book.setString(1, p_fname);
                                stmt_book.setString(2, p_lname);
                                stmt_book.setString(3, age);
                                stmt_book.setString(4, gender);
                                stmt_book.setString(5, apdate);
                                stmt_book.setString(6, aptime);
                                stmt_book.setString(7, contact);
                                stmt_book.setString(8, patient_problem);
                                stmt_book.setString(9, user_user_name);

                                stmt_book.executeUpdate();

                                PreparedStatement history = connection.prepareStatement(app_history);
                                history.setString(1, p_fname);
                                history.setString(2, p_lname);
                                history.setString(3, age);
                                history.setString(4, gender);
                                history.setString(5, apdate);
                                history.setString(6, aptime);
                                history.setString(7, contact);
                                history.setString(8, patient_problem);
                                history.setString(9, user_user_name);

                                history.executeUpdate();

                                String change = "update slots set slots_available=slots_available-1 where slot_timing=?";
                                PreparedStatement stmt_update = connection.prepareStatement(change);

                                stmt_update.setString(1, aptime);

                                stmt_update.executeUpdate();

                                JOptionPane.showMessageDialog(null, "Appointment booked Successfully");

                                new menu(f, user_user_name);
                            }

                            else if (data_check == 0) {
                                JOptionPane.showMessageDialog(null, "Sorry!! Slot not Available");
                            }
                        }

                        connection.close();

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "only numbers are allowed for mobile number");
                    }

                } else if (!data) {
                    JOptionPane.showMessageDialog(null, "Only Characters are allowed for First Name");
                } else if (!data1) {
                    JOptionPane.showMessageDialog(null, "Only Characters are allowed for Last Name");
                } else if (!data2) {
                    JOptionPane.showMessageDialog(null, "Only numbers are allowed for age");
                } else if (!data3) {
                    JOptionPane.showMessageDialog(null, "Only numbers are allowed for Mobile Number");
                } else if (contact.length() != 10) {
                    JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
                } else if (aptime.equals("Your Time Slot will be displayed here")) {
                    JOptionPane.showMessageDialog(null, "You need to Select a Time slot before booking ");
                } else if ((!male.isSelected()) || (!female.isSelected()) || (!other.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Gender is required ");
                }

            } else {
                JOptionPane.showMessageDialog(null, "All inputs are required");
            }
        }

        if (e.getSource() == b19)

        {
            new slot_booking(f, user_user_name);
        }

        if (e.getSource() == male) {
            if (male.isSelected()) {
                female.setEnabled(false);
                other.setEnabled(false);
            } else if ((!male.isSelected())) {
                female.setEnabled(true);
                other.setEnabled(true);
            }

        }

        if (e.getSource() == female) {
            if (female.isSelected()) {
                male.setEnabled(false);
                other.setEnabled(false);
            } else if ((!female.isSelected())) {
                male.setEnabled(true);
                other.setEnabled(true);
            }

        }

        if (e.getSource() == other) {
            if (other.isSelected()) {
                female.setEnabled(false);
                male.setEnabled(false);
            } else if ((!male.isSelected())) {
                female.setEnabled(true);
                male.setEnabled(true);
            }

        }
    }

}
