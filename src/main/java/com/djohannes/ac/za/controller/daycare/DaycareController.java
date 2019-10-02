package com.djohannes.ac.za.controller.daycare;

import com.djohannes.ac.za.domain.Daycare;
import com.djohannes.ac.za.service.impl.DaycareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/daycare")
public class DaycareController {

    @Autowired
    private DaycareServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Daycare create(@RequestBody Daycare daycare)
    {
        return service.create(daycare);
    }

    @PutMapping("/update")
    @ResponseBody
    public Daycare update(@RequestBody Daycare daycare) {
        return service.update(daycare);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Daycare read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Daycare> getAll() {
        return service.getAll();
    }
}