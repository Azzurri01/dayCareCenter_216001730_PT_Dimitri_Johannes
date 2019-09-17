package com.djohannes.ac.za.controller.classroom;


import com.djohannes.ac.za.domain.Classroom;
import com.djohannes.ac.za.factory.ClassroomFactory;
import com.djohannes.ac.za.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dccs/classroom")
public class ClassroomController {
    @Autowired
    @Qualifier("ClassroomServiceImpl")
    private ClassroomService service;

    @PostMapping("/create")
    @ResponseBody
    public Classroom create(@RequestBody Classroom classroom) {
        return service.create(classroom);
    }

    @PostMapping("/update")
    @ResponseBody
    public Classroom update(Classroom classroom) {
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

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Classroom> getAll() {
        return service.getAll();
    }
}
