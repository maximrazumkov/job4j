package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    School school = new School();
    List<Student> students = new ArrayList<>();

    @Before
    public void init() {
        students.add(new Student(12));
        students.add(new Student(52));
        students.add(new Student(78));
        students.add(new Student(68));
        students.add(new Student(9));
        students.add(new Student(92));
    }

    @Test
    public void when10A() {
        List<Student> expect = Arrays.asList(new Student(78), new Student(92));
        List<Student> result = school.collect(students, student -> student.getScore() >= 70);
        assertThat(result, is(expect));
    }

    @Test
    public void when10B() {
        List<Student> expect = Arrays.asList(new Student(52), new Student(68));
        List<Student> result = school.collect(students, student -> (student.getScore() >= 50) && (student.getScore() < 70));
        assertThat(result, is(expect));
    }

    @Test
    public void when10C() {
        List<Student> expect = Arrays.asList(new Student(12), new Student(9));
        List<Student> result = school.collect(students, student -> student.getScore() < 50);
        assertThat(result, is(expect));
    }
}
