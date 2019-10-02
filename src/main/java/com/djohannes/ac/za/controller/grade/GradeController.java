package com.djohannes.ac.za.controller.grade;

import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.service.impl.GradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Grade create(@RequestBody Grade grade)
    {
        return service.create(grade);
    }

    @PutMapping("/update")
    @ResponseBody
    public Grade update(@RequestBody Grade grade) {
        return service.update(grade);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Grade read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Grade> getAll() {
        return service.getAll();
    }
}
