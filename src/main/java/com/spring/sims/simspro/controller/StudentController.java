package com.spring.sims.simspro.controller;

import com.spring.sims.simspro.model.Student;
import com.spring.sims.simspro.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/students")
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    @ApiMethod(description = "Get all hotel bookings from the database")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Student> create(@RequestBody Student student) {

        studentRepository.save(student);

        return studentRepository.findAll();
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Optional<Student> get(@PathVariable Long id) {

        return studentRepository.findById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Student delete(@PathVariable Long id) {
        return StudentStub.delete(id);
    }
}
