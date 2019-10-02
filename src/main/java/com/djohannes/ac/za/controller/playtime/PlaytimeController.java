package com.djohannes.ac.za.controller.playtime;

import com.djohannes.ac.za.domain.playtime.Playtime;
import com.djohannes.ac.za.service.impl.PlaytimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/playtime")
public class PlaytimeController {

    @Autowired
    private PlaytimeServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Playtime create(@RequestBody Playtime playtime)
    {
        return service.create(playtime);
    }

    @PutMapping("/update")
    @ResponseBody
    public Playtime update(@RequestBody Playtime playtime) {
        return service.update(playtime);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Playtime read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Playtime> getAll() {
        return service.getAll();
    }
}