package com.djohannes.ac.za.controller.playtime;


import com.djohannes.ac.za.domain.Playtime;
import com.djohannes.ac.za.service.PlaytimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/playtime")
public class PlaytimeController {
    @Autowired
    @Qualifier("PlaytimeServiceImpl")
    private PlaytimeService service;

    @PostMapping("/create")
    @ResponseBody
    public Playtime create(Playtime playtime) {
        return service.create(playtime);
    }

    @PostMapping("/update")
    @ResponseBody
    public Playtime update(Playtime playtime) {
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

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Playtime> getAll() {
        return service.getAll();
    }
}
