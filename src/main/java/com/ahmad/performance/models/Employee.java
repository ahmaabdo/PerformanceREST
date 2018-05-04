package com.ahmad.performance.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

    private String first_name;
    private String last_name;
    private String username;
    private int salary;

    public Employee() {

    }

    public Employee(String first_name, String last_name, String username, int salary) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.salary = salary;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
