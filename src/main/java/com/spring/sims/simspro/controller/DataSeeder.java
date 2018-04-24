package com.spring.sims.simspro.controller;

import com.spring.sims.simspro.model.Student;
import com.spring.sims.simspro.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

public class DataSeeder {


    @Component
    public class DatabaseSeeder implements CommandLineRunner {
        private StudentRepository studentRepository;

        @Autowired
        public DatabaseSeeder(StudentRepository studentRepository){
            this.studentRepository = studentRepository;
        }

        @Override
        public void run(String... strings) throws Exception {
            List<Student> students = new ArrayList<>();


            Student s1 = new Student(100,"Pearl","CSE",917432343,"chennai,India");

            Student s2 = new Student(101,"Muel","CSE",917432343,"chennai,India");

            Student s3 = new Student(102,"Curl","CSE",917432343,"chennai,India");

            Student s4 = new Student(103,"Get","CSE",917432343,"chennai,India");
            students.add(s1);
            students.add(s2);
            students.add(s3);
            students.add(s4);

            studentRepository.saveAll(students);
//            studentRepository.save(students)
        }
    }
}
