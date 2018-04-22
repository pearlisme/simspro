package com.spring.sims.simspro.controller;

import com.spring.sims.simspro.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")
public class StudentController {

    @RequestMapping(value = "students",method = RequestMethod.GET)
    public List<Student> list(){
            return StudentStub.list();
    }

    @RequestMapping(value = "students",method = RequestMethod.POST)
    public Student create(@RequestBody Student student){
            return StudentStub.create(student);
    }

    @RequestMapping(value = "students/{id}",method = RequestMethod.GET)
    public Student get(@PathVariable Long id){
            return StudentStub.get(id);
    }

    @RequestMapping(value = "students/{id}", method = RequestMethod.PUT)
    public Student update(@PathVariable Long id,@RequestBody Student student){
            return StudentStub.update(id,student);
    }

    @RequestMapping(value = "students/{id}",method = RequestMethod.DELETE)
    public Student delete(@PathVariable Long id){
            return StudentStub.delete(id);
    }
}
