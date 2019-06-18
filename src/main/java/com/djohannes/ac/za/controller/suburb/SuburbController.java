package com.djohannes.ac.za.controller.suburb;


import com.djohannes.ac.za.domain.Suburb;
import com.djohannes.ac.za.service.SuburbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/suburb")
public class SuburbController {
    @Autowired
    @Qualifier("SuburbServiceImpl")
    private SuburbService service;

    @PostMapping("/create")
    @ResponseBody
    public Suburb create(Suburb suburb) {
        return service.create(suburb);
    }

    @PostMapping("/update")
    @ResponseBody
    public Suburb update(Suburb suburb) {
        return service.update(suburb);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Suburb read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Suburb> getAll() {
        return service.getAll();
    }
}
