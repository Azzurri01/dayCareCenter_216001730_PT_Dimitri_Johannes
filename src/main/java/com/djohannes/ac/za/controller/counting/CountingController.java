package com.djohannes.ac.za.controller.counting;

import com.djohannes.ac.za.domain.Counting;
import com.djohannes.ac.za.service.impl.CountingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/counting")
public class CountingController {

    @Autowired
    private CountingServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Counting create(@RequestBody Counting counting)
    {
        return service.create(counting);
    }

    @PutMapping("/update")
    @ResponseBody
    public Counting update(@RequestBody Counting counting) {
        return service.update(counting);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Counting read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Counting> getAll() {
        return service.getAll();
    }
}
