package com.djohannes.ac.za.controller.population;

import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.service.impl.PopulationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/population")
public class PopulationController {

    @Autowired
    private PopulationServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Population create(@RequestBody Population population)
    {
        return service.create(population);
    }

    @PutMapping("/update")
    @ResponseBody
    public Population update(@RequestBody Population population) {
        return service.update(population);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Population read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Population> getAll() {
        return service.getAll();
    }
}
