package com.djohannes.ac.za.controller.parent;

import com.djohannes.ac.za.domain.Parent;
import com.djohannes.ac.za.service.impl.ParentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Parent create(@RequestBody Parent parent)
    {
        return service.create(parent);
    }

    @PutMapping("/update")
    @ResponseBody
    public Parent update(@RequestBody Parent parent) {
        return service.update(parent);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Parent read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Parent> getAll() {
        return service.getAll();
    }
}
