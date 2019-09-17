package com.djohannes.ac.za.controller.city;


import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dccs/city")
public class CityController {
    @Autowired
    @Qualifier("CityServiceImpl")
    private CityService service;

    @PostMapping("/create")
    @ResponseBody
    public City create(@RequestBody City city) {
        return service.create(city);
    }

    @PostMapping("/update")
    @ResponseBody
    public City update(City city) {
        return service.update(city);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public City read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<City> getAll() {
        return service.getAll();
    }
}
