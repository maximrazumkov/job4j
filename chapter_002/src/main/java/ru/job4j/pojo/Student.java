package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String firstname;
    private String surename;
    private String middlename;
    private String group;
    private Date date;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", surename='" + surename + '\'' +
                ", middlename='" + middlename + '\'' +
                ", group='" + group + '\'' +
                ", date=" + date +
                '}';
    }
}
