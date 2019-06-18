package com.djohannes.ac.za.controller.counting;


import com.djohannes.ac.za.domain.Counting;
import com.djohannes.ac.za.service.CountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/counting")
public class CountingController {
    @Autowired
    @Qualifier("CountingServiceImpl")
    private CountingService service;

    @PostMapping("/create")
    @ResponseBody
    public Counting create(Counting counting) {
        return service.create(counting);
    }

    @PostMapping("/update")
    @ResponseBody
    public Counting update(Counting counting) {
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

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Counting> getAll() {
        return service.getAll();
    }
}
