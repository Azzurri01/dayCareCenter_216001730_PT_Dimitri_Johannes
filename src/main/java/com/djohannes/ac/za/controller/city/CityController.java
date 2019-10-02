package com.djohannes.ac.za.controller.city;

import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public City create(@RequestBody City city)
    {
        return service.create(city);
    }

    @PutMapping("/update")
    @ResponseBody
    public City update(@RequestBody City city) {
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

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getAll() {
        return service.getAll();
    }
}