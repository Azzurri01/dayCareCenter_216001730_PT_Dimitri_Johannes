package com.djohannes.ac.za.controller.colour;


import com.djohannes.ac.za.domain.Colour;
import com.djohannes.ac.za.service.ColourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/colour")
public class ColourController {
    @Autowired
    @Qualifier("ColourServiceImpl")
    private ColourService service;

    @PostMapping("/create")
    @ResponseBody
    public Colour create(Colour colour) {
        return service.create(colour);
    }

    @PostMapping("/update")
    @ResponseBody
    public Colour update(Colour colour) {
        return service.update(colour);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Colour read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Colour> getAll() {
        return service.getAll();
    }
}
