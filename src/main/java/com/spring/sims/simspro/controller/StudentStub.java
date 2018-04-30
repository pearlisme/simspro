package com.spring.sims.simspro.controller;

import com.spring.sims.simspro.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/mock")
public class StudentStub {


    public static Map<Long, Student> students = new HashMap<>();

    static {
        Student s1 = new Student(100, "Pearl", "CSE", 917432343, "chennai,India");
        students.put(1L, s1);
        Student s2 = new Student(101, "Muel", "CSE", 917432343, "chennai,India");
        students.put(2L, s2);
        Student s3 = new Student(102, "Curl", "CSE", 917432343, "chennai,India");
        students.put(3L, s3);
        Student s4 = new Student(103, "Get", "CSE", 917432343, "chennai,India");
        students.put(4L, s4);
    }

    @RequestMapping(value = "/students")
    public static List<Student> list() {
        return new ArrayList<Student>(students.values());
    }

    public static Student create(Student student) {
        if (students.containsKey(student)) {
            Long id = new Random().nextLong();
        }
        students.put(student.getId(), student);
        return student;
    }

    public static Student get(Long id) {

        return new Student();
    }

    public static Student update(Long id, Student student) {
        return student;
    }

    public static Student delete(Long id) {
        return new Student();
    }
}
