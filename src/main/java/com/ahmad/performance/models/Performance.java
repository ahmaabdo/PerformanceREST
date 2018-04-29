package com.ahmad.performance.models;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Performance {

    private String comments;
    private String username;
    private int job_know;
    private int work_quality;
    private int attitude;
    private int com_skills;
    private int dependability;

    public Performance() {
    }

    public Performance(String comments, String username, int job_know, int work_quality, int attitude, int com_skills, int dependability) {
        this.comments = comments;
        this.username = username;
        this.job_know = job_know;
        this.work_quality = work_quality;
        this.attitude = attitude;
        this.com_skills = com_skills;
        this.dependability = dependability;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getJob_know() {
        return job_know;
    }

    public void setJob_know(int job_know) {
        this.job_know = job_know;
    }

    public int getWork_quality() {
        return work_quality;
    }

    public void setWork_quality(int work_quality) {
        this.work_quality = work_quality;
    }

    public int getAttitude() {
        return attitude;
    }

    public void setAttitude(int attitude) {
        this.attitude = attitude;
    }

    public int getCom_skills() {
        return com_skills;
    }

    public void setCom_skills(int com_skills) {
        this.com_skills = com_skills;
    }

    public int getDependability() {
        return dependability;
    }

    public void setDependability(int dependability) {
        this.dependability = dependability;
    }
}
