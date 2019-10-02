package com.djohannes.ac.za.controller.teacher;

import com.djohannes.ac.za.domain.teacher.Teacher;
import com.djohannes.ac.za.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Teacher create(@RequestBody Teacher teacher)
    {
        return service.create(teacher);
    }

    @PutMapping("/update")
    @ResponseBody
    public Teacher update(@RequestBody Teacher teacher) {
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

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Teacher> getAll() {
        return service.getAll();
    }
}


