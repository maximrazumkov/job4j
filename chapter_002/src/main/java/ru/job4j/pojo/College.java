package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstname("Maxim");
        student.setSurename("Razumkov");
        student.setMiddlename("Sergeevich");
        student.setGroup("DEK-501");
        student.setDate(new Date());
        System.out.println("Student: " +
                "firstname: " + student.getFirstname() +
                ", surename: " + student.getSurename() +
                ", middlename: " + student.getMiddlename() +
                ", group: " + student.getGroup() +
                ", date: " + student.getDate()
        );
    }
}
