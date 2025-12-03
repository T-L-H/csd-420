// Tevyah Hanley 12/02/2025 M8 Programming Assignment
// This program will connect to a MySQL database and retrieve the current date and time.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/databasedb";
        String user = "student1";
        String pass = "pass";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successful!");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NOW()");

            if (rs.next()) {
                System.out.println("Database responded: " + rs.getString(1));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
