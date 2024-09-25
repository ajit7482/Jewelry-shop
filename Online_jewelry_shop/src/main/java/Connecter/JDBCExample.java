package Connecter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelryshop", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM jewelry_item");

            while (rs.next()) {
                System.out.println("Item Name: " + rs.getString("name"));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

