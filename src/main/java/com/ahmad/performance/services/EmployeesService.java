package com.ahmad.performance.services;

import com.ahmad.performance.db.Database;
import com.ahmad.performance.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeesService {

    private Map<String, Employee> employees = Database.getEmployee();

    public EmployeesService() {
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public Employee getEmployee(String username) {
        return employees.get(username);
    }

    public Employee addEmployee(Employee employee) {
        employees.put(employee.getUsername(), employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        employees.put(employee.getUsername(), employee);
        return employee;
    }

    public Employee removeEmployee(String username) {
        return employees.remove(username);
    }
}
