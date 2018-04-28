package com.ahmad.performance.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestConnection {

    //public JDBC() {

    public static void main(String[] argv) {
        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Oracle JDBC Driver not found?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "ahmad", "0000");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("Connection success");
        } else {
            System.out.println("Failed to make connection!");
        }

    }
}

