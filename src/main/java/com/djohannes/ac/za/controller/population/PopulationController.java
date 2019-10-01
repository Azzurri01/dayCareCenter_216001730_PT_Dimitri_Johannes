package com.djohannes.ac.za.controller.population;


import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/dccs/population")
public class PopulationController {
    @Autowired
    @Qualifier("PopulationServiceImpl")
    private PopulationService service;

    @PostMapping("/create")
    @ResponseBody
    public Population create(@RequestBody  Population population) {
        return service.create(population);
    }

    @PostMapping("/update")
    @ResponseBody
    public Population update(Population population) {
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

    @GetMapping("/read/all")
    @ResponseBody
    public List<Population> getAll() {
        return service.getAll();
    }
}
