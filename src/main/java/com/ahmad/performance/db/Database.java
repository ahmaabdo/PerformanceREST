package com.ahmad.performance.db;

import com.ahmad.performance.models.Employee;
import com.ahmad.performance.models.Performance;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private static Map<Long, Employee> employee = new HashMap<>();
    private static Map<Long, Performance> performance = new HashMap<>();

    public static Map<Long, Employee> getEmployee() {
        return employee;
    }

    public static Map<Long, Performance> getPerformance() {
        return performance;
    }
}
