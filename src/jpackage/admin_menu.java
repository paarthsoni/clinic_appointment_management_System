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

public class admin_menu extends JFrame implements login_user, ActionListener {

    JButton b1, b2, b3, b4, b5;
    String admin_user_name;

    public admin_menu(JFrame f, String admin_username) {
        admin_user_name = admin_username;

        f.getContentPane().removeAll();
        f.repaint();
        // f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        b1 = new JButton("View Appointments");
        b1.setBounds(670, 200, 250, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Add another admin");
        b2.setBounds(670, 300, 250, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Update Slots");
        b3.setBounds(670, 400, 250, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.addActionListener(this);
        f.add(b3);

        b5 = new JButton("Delete All Today's Appointments");
        b5.setBounds(635, 500, 340, 50);
        b5.setFont(new Font("Helvetica", Font.BOLD, 17));
        b5.addActionListener(this);
        f.add(b5);

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

        if (e.getSource() == b1) {
            new view_appointments(f, admin_user_name);
        }

        if (e.getSource() == b5) {
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

            if (hours >= 21 && minutesIntoTheDay >= 1262 && hours <= 23 && minutesIntoTheDay <= 1440) {
                String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
                String username_db = "tklsjaddlzcmwj";
                String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";

                try {
                    Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                    String delete_slots = "truncate appointments";

                    Statement stmt_truncate = connection.createStatement();

                    stmt_truncate.executeUpdate(delete_slots);
                    JOptionPane.showMessageDialog(f, "Today's Appointment Deleted Successfully");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(f, "Server Error");
                }

            } else {
                JOptionPane.showMessageDialog(f, "Sorry!! Deleting Today's Slots is possible after 9:00 pm");
            }

        }

        if (e.getSource() == b3) {

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

            if (hours >= 16 /* && minutesIntoTheDay >= 480 && hours <= 9 && minutesIntoTheDay <= 540 */) {
                String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
                String username_db = "tklsjaddlzcmwj";
                String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";
                try {
                    Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                    String update_slot = "update slots set slots_available=3 where slot_timing=?";

                    PreparedStatement statement_update = connection.prepareStatement(update_slot);

                    String slot1 = "9:00 - 9:30";
                    String slot2 = "9:30 - 10:00";
                    String slot3 = "10:00 - 10:30";
                    String slot4 = "10:30 - 11:00";
                    String slot5 = "11:00 - 11:30";
                    String slot6 = "11:30 - 12:00";
                    String slot7 = "12:00 - 12:30";
                    String slot8 = "12:30 - 1:00";
                    String slot9 = "5:00 - 5:30";
                    String slot10 = "5:30 - 6:00";
                    String slot11 = "6:00 - 6:30";
                    String slot12 = "6:30 - 7:00";
                    String slot13 = "7:00 - 7:30";
                    String slot14 = "7:30 - 8:00";

                    String slot15 = "8:00 - 8:30";
                    String slot16 = "8:30 - 9:00";

                    statement_update.setString(1, slot1);
                    statement_update.executeUpdate();

                    statement_update.setString(1, slot2);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot3);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot4);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot5);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot6);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot7);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot8);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot9);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot10);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot11);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot12);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot13);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot14);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot15);
                    statement_update.executeUpdate();
                    statement_update.setString(1, slot16);
                    statement_update.executeUpdate();
                    JOptionPane.showMessageDialog(f, "Slots Updated Successfully");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(f, "Server Error");
                }
            } else {
                JOptionPane.showMessageDialog(f, "Sorry!! Can't Update Now");
            }

        }

        if (e.getSource() == b4) {

            JOptionPane.showMessageDialog(f, "Logged out Successfully");
            new login();

        }

    }
}
