package com.ahmad.performance.services;

import com.ahmad.performance.db.Database;
import com.ahmad.performance.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeesService {

    private Map<Long, Employee> employees = Database.getEmployee();

    public EmployeesService() {
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public Employee getEmployee(long id) {
        return employees.get(id);
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmp_no(employees.size() + 1);
        employees.put(employee.getEmp_no(), employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        if (employee.getEmp_no() <= 0) {
            return null;
        }
        employees.put(employee.getEmp_no(), employee);
        return employee;
    }

    public Employee removeEmployee(long emp_no) {
        return employees.remove(emp_no);
    }
}
