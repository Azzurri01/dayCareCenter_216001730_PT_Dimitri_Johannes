package com.djohannes.ac.za.controller.activity;

import com.djohannes.ac.za.domain.Activity;
import com.djohannes.ac.za.service.impl.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Activity create(@RequestBody Activity activity)
    {
        return service.create(activity);
    }

    @PutMapping("/update")
    @ResponseBody
    public Activity update(@RequestBody Activity activity) {
        return service.update(activity);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Activity read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Activity> getAll() {
        return service.getAll();
    }
}