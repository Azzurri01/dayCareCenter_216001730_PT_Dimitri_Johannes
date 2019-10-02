package com.djohannes.ac.za.controller.classroom;

import com.djohannes.ac.za.domain.Classroom;
import com.djohannes.ac.za.service.impl.ClassroomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Classroom create(@RequestBody Classroom classroom)
    {
        return service.create(classroom);
    }

    @PutMapping("/update")
    @ResponseBody
    public Classroom update(@RequestBody Classroom classroom) {
        return service.update(classroom);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Classroom read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Classroom> getAll() {
        return service.getAll();
    }
}