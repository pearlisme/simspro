package com.spring.sims.simspro.service;

import com.spring.sims.simspro.model.Student;
import com.spring.sims.simspro.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Service
@RequestMapping("/student")
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public void create(Student student){
        studentRepository.save(student);
    }

    @RequestMapping(value = "/find/${id}",method = RequestMethod.GET)
    public List<Student> find(@PathVariable Long id){
        studentRepository.findAllById(id);
    }

    @RequestMapping(value = "/delete/${id}",method = RequestMethod.GET)
    public void delete(@PathVariable Long id){
        studentRepository.findAllById(id);
    }




}
