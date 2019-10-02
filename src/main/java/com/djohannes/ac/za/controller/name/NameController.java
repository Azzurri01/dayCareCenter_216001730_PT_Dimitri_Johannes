package com.djohannes.ac.za.controller.name;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.service.impl.NameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/name")
public class NameController {

    @Autowired
    private NameServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Name create(@RequestBody Name name)
    {
        return service.create(name);
    }

    @PutMapping("/update")
    @ResponseBody
    public Name update(@RequestBody Name name) {
        return service.update(name);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Name read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Name> getAll() {
        return service.getAll();
    }
}