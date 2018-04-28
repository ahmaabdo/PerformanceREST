package com.ahmad.performance.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCConnection {

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "ahmad";
    private static final String PASS = "0000";


    public static void main(String[] argv) {

        //Select from table example
        String query = "SELECT * FROM AHMAD.EMPLOYEE";

        //Insert into table example
        String insertTableSQL = "INSERT INTO EMPLOYEE"
                + "(USERNAME, FIRST_NAME, LAST_NAME, SALARY) " + "VALUES"
                + "('ahmad2','Ahmed','Abdo', '1000')";

        try {
            Class.forName(JDBC_DRIVER);

            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement st = connection.createStatement();
            //Insert into db
            st.executeQuery(insertTableSQL);

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("EMP_ID");
                String username = rs.getString("USERNAME");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                int salary = rs.getInt("SALARY");
                // print the results
                System.out.format("%s, %s, %s, %s, %s\n", id, username, firstName, lastName, salary);
            }
            //Close db connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}