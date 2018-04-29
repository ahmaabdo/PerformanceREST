package com.ahmad.performance.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC {

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "ahmad";
    private static final String PASS = "0000";

    public static void main(String[] argv) {

        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM AHMAD.EMPLOYEE");
            ResultSetMetaData resultSetMetaData = result.getMetaData();

            List<String> columns = new ArrayList<>(resultSetMetaData.getColumnCount());
            List<Map<String, String>> data = new ArrayList<>();

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                columns.add(resultSetMetaData.getColumnName(i));
            }

            while (result.next()) {
                Map<String, String> row = new HashMap<>(columns.size());
                for (String col : columns) {
                    row.put(col, result.getString(col));
                }
                data.add(row);
            }

            System.out.println(data);
            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
