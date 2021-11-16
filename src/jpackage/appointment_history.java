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

public class appointment_history extends JFrame implements ActionListener, login_user {

    String user_user_name;
    JTable t1;
    JFrame f1;
    JLabel l;

    public appointment_history(JFrame f, String user_username) {
        user_user_name = user_username;
        // f.getContentPane().removeAll();
        // f.repaint();
        // f.getContentPane().setBackground(Color.green);
        // f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // f.setDefaultLookAndFeelDecorated(true);

        String jdbcURL = "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d1itre8d1ofteb";
        String username_db = "tklsjaddlzcmwj";
        String password_db = "0a962d95cc35d5a21dc4081cf4bca8abe21fa22727cee6e31b746df3cb4ffd47";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username_db, password_db);

            String history_check = "SELECT CASE WHEN EXISTS ( SELECT * FROM appointment_history WHERE user_username=?) THEN 'TRUE' ELSE 'FALSE' END";

            PreparedStatement stmt_history = connection.prepareStatement(history_check);

            stmt_history.setString(1, user_user_name);

            ResultSet his = stmt_history.executeQuery();

            while (his.next()) {
                String value = his.getString("case");
                if (value.equals("TRUE")) {
                    f1 = new JFrame("Appointment History");
                    f1.getContentPane().setBackground(Color.green);
                    f1.setSize(500, 500);
                    f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    f1.setDefaultLookAndFeelDecorated(true);
                    f1.setVisible(true);
                    f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                    DefaultTableModel model = new DefaultTableModel();

                    t1 = new JTable(model);
                    t1.setRowHeight(40);
                    model.addColumn("Appointment ID");
                    model.addColumn("Patient's First Name");
                    model.addColumn("Patient's last Name");
                    model.addColumn("Acoount username");
                    model.addColumn("Age");
                    model.addColumn("Gender");
                    model.addColumn("Appointment Date");
                    model.addColumn("Appointment Time");
                    model.addColumn("Contact Number");
                    model.addColumn("Patient's Problem");

                    String history = "select * from appointment_history where user_username=?";

                    PreparedStatement stmt_history_data = connection.prepareStatement(history);

                    stmt_history_data.setString(1, user_user_name);

                    ResultSet history_data = stmt_history_data.executeQuery();

                    while (history_data.next()) {
                        String id = history_data.getString("id");
                        String p_fname = history_data.getString("p_fname");
                        String p_lname = history_data.getString("p_lname");
                        String username = history_data.getString("user_username");
                        String age = history_data.getString("age");
                        String gender = history_data.getString("gender");
                        String appointment_date = history_data.getString("appointment_date");
                        String appointment_time = history_data.getString("appointment_time");
                        String contact = history_data.getString("contact_num");
                        String patient_problem = history_data.getString("patient_problem");

                        model.addRow(new Object[] { id, p_fname, p_lname, username, age, gender, appointment_date,
                                appointment_time, contact, patient_problem });

                    }

                    JScrollPane sp = new JScrollPane(t1);
                    f1.add(sp);

                }

                else if (value.equals("FALSE")) {
                    JOptionPane.showMessageDialog(null, "NO Appointment History available for this account");
                }
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Server Error");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
