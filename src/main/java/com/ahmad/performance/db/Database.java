package com.ahmad.performance.db;

import com.ahmad.performance.models.Employee;
import com.ahmad.performance.models.Performance;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private static Map<String, Employee> employee = new HashMap<>();
    private static Map<String, Performance> performance = new HashMap<>();

    public static Map<String, Employee> getEmployee() {
        return employee;
    }

    public static Map<String, Performance> getPerformance() {
        return performance;
    }
}
