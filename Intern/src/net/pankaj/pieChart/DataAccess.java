package net.pankaj.pieChart;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccess {
        private static Connection connection = null;

        public static Connection getConnection() {
        	
        	System.out.println("in piechart database DataAccess");
                if (connection != null)
                        return connection;
                else {
                
                String dbUrl = "jdbc:mysql://localhost:3306/manage";
                try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(dbUrl, "root", "12345");
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return connection;
        }
        }
}