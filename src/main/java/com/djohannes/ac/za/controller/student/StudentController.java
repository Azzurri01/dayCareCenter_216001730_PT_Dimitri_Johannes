package com.djohannes.ac.za.controller.student;


import com.djohannes.ac.za.domain.Student;
import com.djohannes.ac.za.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dccs/student")
public class StudentController {
    @Autowired
    @Qualifier("StudentServiceImpl")
    private StudentService service;

    @PostMapping("/create")
    @ResponseBody
    public Student create(@RequestBody Student student) {
        return service.create(student);
    }

    @PostMapping("/update")
    @ResponseBody
    public Student update(Student student) {
        return service.update(student);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Student read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Student> getAll() {
        return service.getAll();
    }
}
