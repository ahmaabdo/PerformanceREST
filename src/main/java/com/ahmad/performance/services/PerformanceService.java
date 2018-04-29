package com.ahmad.performance.services;

import com.ahmad.performance.db.Database;
import com.ahmad.performance.models.Performance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PerformanceService {

    private Map<String, Performance> performances = Database.getPerformance();

    public PerformanceService() {
    }

    public List<Performance> getAllPerformance() {
        return new ArrayList<>(performances.values());
    }

    public Performance getPerformance(String username) {
        return performances.get(username);
    }

    public Performance addPerformance(Performance performance) {
        performances.put(performance.getUsername(), performance);
        return performance;
    }

    public Performance updatePerformance(Performance performance) {

        performances.put(performance.getUsername(), performance);
        return performance;
    }

    public Performance removePerformance(String username) {
        return performances.remove(username);
    }
}
