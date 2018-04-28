package com.ahmad.performance.services;

import com.ahmad.performance.db.Database;
import com.ahmad.performance.models.Performance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PerformanceService {

    private Map<Long, Performance> performances = Database.getPerformance(); 

    public PerformanceService() {
    }

    public List<Performance> getAllPerformance() {
        return new ArrayList<>(performances.values());
    }

    public Performance getPerformance(long emp_no) {
        return performances.get(emp_no);
    }

    public Performance addPerformance(Performance performance) {
        performance.setEmp_no(performances.size() + 1);
        performances.put(performance.getEmp_no(), performance);
        return performance;
    }

    public Performance updatePerformance(Performance performance) {
        if (performance.getEmp_no() <= 0) {
            return null;
        }
        performances.put(performance.getEmp_no(), performance);
        return performance;
    }

    public Performance removePerformance(long emp_no) {
        return performances.remove(emp_no);
    }
}
