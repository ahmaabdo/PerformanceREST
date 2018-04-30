package com.ahmad.performance.services;

import com.ahmad.performance.models.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeesService {

    // private Map<String, Employee> employees = Database.getEmployee();

    private ArrayList<Employee> employeesList = new ArrayList<>();

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "ahmad";
    private static final String PASS = "0000";

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet result = null;

    public EmployeesService() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {

        try {
            result = statement.executeQuery("SELECT * FROM AHMAD.EMPLOYEE");
            while (result.next()) {

                Employee employee = new Employee();

                String username = result.getString("USERNAME");
                String firstName = result.getString("FIRST_NAME");
                String lastName = result.getString("LAST_NAME");
                int salary = result.getInt("SALARY");

                employee.setUsername(username);
                employee.setFirst_name(firstName);
                employee.setLast_name(lastName);
                employee.setSalary(salary);

                employeesList.add(employee);
            }
            //Close all connections
            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeesList;
    }

    public Employee getEmployee(String username) {

        Employee employee = new Employee();
        try {
            result = statement.executeQuery("SELECT * FROM AHMAD.EMPLOYEE WHERE USERNAME = " + "'" + username + "'");
            while (result.next()) {
                String firstName = result.getString("FIRST_NAME");
                String lastName = result.getString("LAST_NAME");
                int salary = result.getInt("SALARY");

                employee.setFirst_name(firstName);
                employee.setLast_name(lastName);
                employee.setSalary(salary);
            }
            //Close all connections
            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employee;
    }

    public Employee addEmployee(Employee employee) {
        try {
            String insertTableSQL = "INSERT INTO EMPLOYEE"
                    + "(USERNAME, FIRST_NAME, LAST_NAME, SALARY) " + "VALUES" + "( '"
                    + employee.getUsername() + "', '"
                    + employee.getFirst_name() + "', '"
                    + employee.getLast_name() + "', '"
                    + employee.getSalary() + "' )";

                result = statement.executeQuery(insertTableSQL);

            //Close all connections
            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        try {

            String updateTableSQL = "UPDATE AHMAD.EMPLOYEE SET "
                    + "FIRST_NAME = '" + employee.getFirst_name() + "', "
                    + "LAST_NAME =  '" + employee.getLast_name() + "', "
                    + "SALARY =  '" + employee.getSalary() + "' "
                    + "WHERE USERNAME = '" + employee.getUsername() + "'";

            result = statement.executeQuery(updateTableSQL);

            //Close all connections
            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employee;
    }

    public Employee removeEmployee(String username) {
        Employee employee = new Employee();
        try {
            // int update = statement.executeUpdate("delete from ahmad.employee where username = 'ahmad123'");
            //System.out.println(update);

            result = statement.executeQuery("DELETE FROM AHMAD.EMPLOYEE WHERE USERNAME = " + "'" + username + "'");

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employee;
    }
}
