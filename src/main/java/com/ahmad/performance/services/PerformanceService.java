package com.ahmad.performance.services;

import com.ahmad.performance.db.Database;
import com.ahmad.performance.models.Performance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PerformanceService {

    private Map<String, Performance> performances = Database.getPerformance();

    private ArrayList<Performance> performanceList = new ArrayList<>();


    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "ahmad";
    private static final String PASS = "0000";

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet result = null;

    public PerformanceService() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Performance> getAllPerformance() {
        try {
            result = statement.executeQuery("SELECT * FROM AHMAD.PERFORMANCE");
            while (result.next()) {

                Performance performance = new Performance();

                String username = result.getString("USERNAME");
                int attitude = result.getInt("ATTITUDE");
                int comSkills = result.getInt("COM_SKILLS");
                int jobKnow = result.getInt("JOB_KNOW");
                int workQuality = result.getInt("WORK_QUALITY");
                int dependability = result.getInt("DEPENDABILITY");

                performance.setUsername(username);
                performance.setAttitude(attitude);
                performance.setCom_skills(comSkills);
                performance.setJob_know(jobKnow);
                performance.setWork_quality(workQuality);
                performance.setDependability(dependability);

                performanceList.add(performance);
            }
            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return performanceList;
    }


    public Performance getPerformance(String username) {
        Performance performance = new Performance();
        try {
            result = statement.executeQuery("SELECT * FROM AHMAD.PERFORMANCE WHERE USERNAME = " + "'" + username + "'");
            while (result.next()) {
                int attitude = result.getInt("ATTITUDE");
                int comSkills = result.getInt("COM_SKILLS");
                int jobKnow = result.getInt("JOB_KNOW");
                int workQuality = result.getInt("WORK_QUALITY");
                int dependability = result.getInt("DEPENDABILITY");
                String comment = result.getString("COMMENTS");

                performance.setAttitude(attitude);
                performance.setCom_skills(comSkills);
                performance.setJob_know(jobKnow);
                performance.setWork_quality(workQuality);
                performance.setDependability(dependability);
                performance.setComments(comment);
            }
            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
        }

        return performance;
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
