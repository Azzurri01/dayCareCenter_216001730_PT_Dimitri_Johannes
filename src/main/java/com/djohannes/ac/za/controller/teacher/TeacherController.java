package com.djohannes.ac.za.controller.teacher;


import com.djohannes.ac.za.domain.Teacher;
import com.djohannes.ac.za.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    @Qualifier("TeacherServiceImpl")
    private TeacherService service;

    @PostMapping("/create")
    @ResponseBody
    public Teacher create(@RequestBody Teacher teacher) {
        return service.create(teacher);
    }

    @PostMapping("/update")
    @ResponseBody
    public Teacher update(Teacher teacher) {
        return service.update(teacher);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Teacher read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Teacher> getAll() {
        return service.getAll();
    }
}
