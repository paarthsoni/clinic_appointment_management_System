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

public class search_appointment extends JFrame implements ActionListener, login_user {

    String admin_user_name;
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3;

    public search_appointment(JFrame f, String admin_username) {
        admin_user_name = admin_username;
        f.getContentPane().removeAll();
        f.repaint();
        // f.getContentPane().setBackground(Color.green);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);

        l4 = new JLabel("Search Appointment");
        l4.setBounds(650, 140, 350, 30);
        l4.setFont(new Font("Helvetica", Font.BOLD, 27));
        l4.setForeground(Color.red);
        f.add(l4);

        l1 = new JLabel("Enter Appointment ID:");
        l1.setBounds(540, 240, 225, 30);
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l1);
        t1 = new RoundJTextField(15);
        t1.setBounds(765, 240, 200, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t1);

        l2 = new JLabel("Enter First Name:");
        l2.setBounds(540, 340, 225, 30);
        l2.setFont(new Font("Helvetica", Font.BOLD, 20));
        l2.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l2);
        t2 = new RoundJTextField(15);
        t2.setBounds(765, 340, 200, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t2);

        l3 = new JLabel("Enter Last Name:");
        l3.setBounds(540, 440, 225, 30);
        l3.setFont(new Font("Helvetica", Font.BOLD, 20));
        l3.setForeground(Color.BLACK.darker().darker().darker().darker().darker());
        f.add(l3);
        t3 = new RoundJTextField(15);
        t3.setBounds(765, 440, 200, 30);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        f.add(t3);

        b3 = new JButton("Go back to Menu");
        b3.setBounds(500, 540, 250, 50);
        b3.setFont(new Font("Helvetica", Font.BOLD, 17));
        b3.setBackground(Color.red);
        b3.addActionListener(this);
        f.add(b3);

        b2 = new JButton("Search Appointment");
        b2.setBounds(780, 540, 250, 50);
        b2.setFont(new Font("Helvetica", Font.BOLD, 17));
        b2.setBackground(Color.green);
        b2.addActionListener(this);
        f.add(b2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b2) {
            String id = t1.getText();
            int id_app = Integer.parseInt(id);
            String fname = t2.getText();
            String lname = t3.getText();
            String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
            String username_db = "tklsjaddlzcmwj";
            String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";

            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

                String app_check = "SELECT CASE WHEN EXISTS ( SELECT * FROM appointments WHERE appointment_id=? ) THEN 'TRUE' ELSE 'FALSE' END";

                PreparedStatement stmt_app = connection.prepareStatement(app_check);

                stmt_app.setInt(1, id_app);

                ResultSet data = stmt_app.executeQuery();

                while (data.next()) {
                    String value = data.getString("case");

                    if (value.equals("TRUE")) {
                        JFrame f1 = new JFrame("Appointment History");
                        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        f1.setDefaultLookAndFeelDecorated(true);
                        f1.setVisible(true);
                        f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        DefaultTableModel model = new DefaultTableModel();

                        JTable t1 = new JTable(model);
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
                        String searched_app = "select * from appointments where appointment_id=?";
                        PreparedStatement stmt_search = connection.prepareStatement(searched_app);

                        stmt_search.setInt(1, id_app);

                        ResultSet data_searched = stmt_search.executeQuery();

                        while (data_searched.next()) {
                            int app_id = data_searched.getInt("appointment_id");
                            String p_fname = data_searched.getString("p_fname");
                            String p_lname = data_searched.getString("p_lname");
                            String age = data_searched.getString("age_of_patient");
                            String gender = data_searched.getString("gender");
                            String appointment_date = data_searched.getString("date_of_appointment");
                            String appointment_time = data_searched.getString("time_of_appointment");
                            String contact = data_searched.getString("contact_num");
                            String patient_problem = data_searched.getString("patient_problem");

                            model.addRow(new Object[] { app_id, p_fname, p_lname, age, gender, appointment_date,
                                    appointment_time, contact, patient_problem });

                        }
                        JScrollPane sp = new JScrollPane(t1);
                        f1.add(sp);
                    } else if (value.equals("FALSE")) {
                        JOptionPane.showMessageDialog(null, "NO Such Appointment with Appointment ID = " + id);
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

        if (e.getSource() == b3) {
            new admin_menu(f, admin_user_name);
        }

    }

}
