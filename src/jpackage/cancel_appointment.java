package jpackage;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URISyntaxException;

import jpackage.*;

public class cancel_appointment extends JFrame implements ActionListener, login_user {

    String user_user_name;

    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3;
    JButton b1, b2;

    public cancel_appointment(JFrame f, String user_username) {

        user_user_name = user_username;
        f.getContentPane().removeAll();
        f.repaint();
        // f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l1 = new JLabel("Cancel Appointment");
        l1.setBounds(630, 140, 500, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 26));
        l1.setForeground(Color.RED);
        f.add(l1);

        l2 = new JLabel("Enter your Username:");
        l2.setBounds(530, 200, 250, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundJTextField(15);
        t2.setBounds(760, 200, 250, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        l3 = new JLabel("Enter Patient's First Name:");
        l3.setBounds(530, 270, 310, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);
        t3 = new RoundJTextField(15);
        t3.setBounds(790, 270, 250, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t3);

        l4 = new JLabel("Enter Patient's Last Name:");
        l4.setBounds(530, 340, 250, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 20));
        l4.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l4);
        t1 = new RoundJTextField(15);
        t1.setBounds(790, 340, 250, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        b1 = new JButton("Cancel Appointment");
        b1.setBounds(530, 420, 250, 35);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.setBackground(Color.red);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Go Back to Menu");
        b2.setBounds(790, 420, 250, 35);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.setBackground(Color.green);
        b2.addActionListener(this);
        f.add(b2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String user_username = t2.getText();
            String p_fname = t3.getText();
            String p_lname = t1.getText();

            String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
            String username_db = "tklsjaddlzcmwj";
            String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";
            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String strDate = formatter.format(date);

                String date_check = "SELECT CASE WHEN EXISTS ( SELECT * FROM appointments WHERE user_username=? and date_of_appointment=?) THEN 'TRUE' ELSE 'FALSE' END";

                PreparedStatement stmt_date = connection.prepareStatement(date_check);

                stmt_date.setString(1, user_user_name);
                stmt_date.setString(2, strDate);

                ResultSet datecheck = stmt_date.executeQuery();

                while (datecheck.next()) {
                    String value = datecheck.getString("case");
                    if (value.equals("TRUE")) {

                        String cancel_check = "select user_username, p_fname,p_lname , date_of_appointment, time_of_appointment from appointments where user_username=? and p_fname=? and p_lname=?";
                        PreparedStatement select_cancel_check = connection.prepareStatement(cancel_check);

                        select_cancel_check.setString(1, user_user_name);
                        select_cancel_check.setString(2, p_fname);
                        select_cancel_check.setString(3, p_lname);

                        ResultSet cancel_app = select_cancel_check.executeQuery();

                        while (cancel_app.next()) {
                            String value_check = cancel_app.getString("date_of_appointment");
                            String app_time = cancel_app.getString("time_of_appointment");

                            if (value_check.equals(strDate)) {
                                String cancel1 = "delete from appointments where user_username=? and p_fname=? and p_lname=?";
                                String cancel2 = "delete from appointment_history where user_username=? and p_fname=? and p_lname=?";

                                String update_slot = "update slots set slots_available=slots_available+1 where slot_timing=?";
                                PreparedStatement select_time = connection.prepareStatement(update_slot);

                                select_time.setString(1, app_time);

                                select_time.executeUpdate();

                                PreparedStatement select = connection.prepareStatement(cancel1);
                                PreparedStatement select1 = connection.prepareStatement(cancel2);

                                select.setString(1, user_user_name);
                                select.setString(2, p_fname);
                                select.setString(3, p_lname);

                                select1.setString(1, user_user_name);
                                select1.setString(2, p_fname);
                                select1.setString(3, p_lname);

                                select.executeUpdate();
                                select1.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Appointment cancelled Successfully");
                                new menu(f, user_username);
                            } else if (!value_check.equals(strDate)) {
                                JOptionPane.showMessageDialog(null, "No Such Appointment Today");
                            }
                        }

                    } else if (value.equals("FALSE")) {
                        // l1.setText("No Appointment(s) Booked Today");
                        JOptionPane.showMessageDialog(null, "No such Appointment ");
                    }
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

        if (e.getSource() == b2)

        {
            new menu(f, user_user_name);
        }

    }

}
