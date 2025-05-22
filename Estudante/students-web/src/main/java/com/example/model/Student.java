package com.example.model;

public class Student {
    private String sid;
    private String username;
    private String email;
    private int year;
    private String department;

    public Student() {}

    public Student(String sid, String username, String email, int year, String department) {
        this.sid = sid;
        this.username = username;
        this.email = email;
        this.year = year;
        this.department = department;
    }

    // Getters and Setters
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}