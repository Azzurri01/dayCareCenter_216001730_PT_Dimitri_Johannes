package com.djohannes.ac.za.controller.grade;


import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    @Qualifier("GradeServiceImpl")
    private GradeService service;

    @PostMapping("/create")
    @ResponseBody
    public Grade create(@RequestBody Grade grade) {
        return service.create(grade);
    }

    @PostMapping("/update")
    @ResponseBody
    public Grade update(Grade grade) {
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

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Grade> getAll() {
        return service.getAll();
    }
}
