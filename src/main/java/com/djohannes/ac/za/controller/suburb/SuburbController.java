package com.djohannes.ac.za.controller.suburb;

import com.djohannes.ac.za.domain.Suburb;
import com.djohannes.ac.za.service.impl.SuburbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/suburb")
public class SuburbController {

    @Autowired
    private SuburbServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Suburb create(@RequestBody Suburb suburb)
    {
        return service.create(suburb);
    }

    @PutMapping("/update")
    @ResponseBody
    public Suburb update(@RequestBody Suburb suburb) {
        return service.update(suburb);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Suburb read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Suburb> getAll() {
        return service.getAll();
    }
}
