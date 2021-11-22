package jpackage;

import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URISyntaxException;

import jpackage.*;

public class view_appointments extends JFrame implements ActionListener, login_user {

    String admin_user_name;
    JTable t1;
    JFrame f1;
    JLabel l, l1;
    JButton b1, b2, b3;

    public view_appointments(JFrame f, String admin_username) {

        admin_user_name = admin_username;
        f.getContentPane().removeAll();
        f.repaint();
        // f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        b1 = new JButton("View all appointments");
        b1.setBounds(670, 250, 250, 50);
        b1.setFont(new Font("Helvetica", Font.BOLD, 17));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Search an appointment");
        b2.setBounds(670, 350, 250, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Go Back to Menu");
        b3.setBounds(670, 450, 250, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.setForeground(Color.red.darker().darker().darker().darker().darker());
        b3.setBackground(Color.red);
        b3.addActionListener(this);
        f.add(b3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
            String username_db = "tklsjaddlzcmwj";
            String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";
            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                String acc_check = "SELECT CASE WHEN EXISTS ( SELECT * FROM admin_account WHERE admin_username=?) THEN 'TRUE' ELSE 'FALSE' END";

                PreparedStatement stmt_acc = connection.prepareStatement(acc_check);

                stmt_acc.setString(1, admin_user_name);

                ResultSet his = stmt_acc.executeQuery();

                while (his.next()) {
                    String value = his.getString("case");
                    if (value.equals("TRUE")) {
                        f1 = new JFrame("Appointment History");
                        // f1.setSize(500, 500);
                        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        f1.setDefaultLookAndFeelDecorated(true);
                        f1.setVisible(true);
                        f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                        // l1 = new JLabel("Search by Name");
                        // l1.setBounds(20, 40, 200, 30);
                        // l1.setFont(new Font("Helvetica", Font.BOLD, 20));
                        // f1.add(l1);

                        DefaultTableModel model = new DefaultTableModel();

                        t1 = new JTable(model);
                        t1.setRowHeight(40);
                        model.addColumn("Appointment ID");
                        model.addColumn("Patient's First Name");
                        model.addColumn("Patient's last Name");
                        model.addColumn("Age");
                        model.addColumn("Gender");
                        model.addColumn("Appointment Date");
                        model.addColumn("Appointment Time");
                        model.addColumn("Contact Number");
                        model.addColumn("Patient's Problem");

                        String appointments = "select * from appointments";

                        Statement stmt_app_data = connection.createStatement();

                        ResultSet app_data = stmt_app_data.executeQuery(appointments);

                        while (app_data.next()) {
                            String id = app_data.getString("appointment_id");
                            String p_fname = app_data.getString("p_fname");
                            String p_lname = app_data.getString("p_lname");
                            String age = app_data.getString("age_of_patient");
                            String gender = app_data.getString("gender");
                            String appointment_date = app_data.getString("date_of_appointment");
                            String appointment_time = app_data.getString("time_of_appointment");
                            String contact = app_data.getString("contact_num");
                            String patient_problem = app_data.getString("patient_problem");

                            model.addRow(new Object[] { id, p_fname, p_lname, age, gender, appointment_date,
                                    appointment_time, contact, patient_problem });

                        }

                        JScrollPane sp = new JScrollPane(t1);
                        f1.add(sp);

                    }

                    else if (value.equals("FALSE")) {
                        JOptionPane.showMessageDialog(null, "NO Appointments available");
                    }
                }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Server Error");
            }

        }

        if (e.getSource() == b2) {
            new search_appointment(f, admin_user_name);
        }

        if (e.getSource() == b3) {
            new admin_menu(f, admin_user_name);
        }
    }

}
