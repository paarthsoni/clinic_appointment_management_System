import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame f = new JFrame("Clinic appointment Management System");
        f.setSize(1024, 768);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultLookAndFeelDecorated(true);
        Label l1 = new Label();
        l1.setBounds(200, 200, 200, 100);
        Label l2 = new Label();
        l2.setBounds(200, 400, 200, 100);
        f.add(l1);
        f.add(l2);
        String jdbcURL = "jdbc:postgresql://localhost:5432/clinic_appointment_management_System";
        String username = "postgres";
        String password = "paarth@2812";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            l1.setText("connected to database servers");

            String sql = " SELECT CASE WHEN EXISTS  ( SELECT * FROM user_account WHERE user_password=crypt('johnspassword',user_password)) THEN 'TRUE' ELSE 'FALSE' END";

            Statement statement = connection.createStatement();
            ResultSet a = statement.executeQuery(sql);
            while (a.next()) {
                String value = a.getString("case");
                if (value.equals("TRUE")) {
                    l2.setText("user found");
                } else if (value.equals("FALSE")) {
                    l2.setText("no such user");
                }
            }

            connection.close();
        } catch (SQLException e) {
            l1.setText("failed to connect the servers");
        }
        f.setLayout(null);
        f.setVisible(true);
    }
}
