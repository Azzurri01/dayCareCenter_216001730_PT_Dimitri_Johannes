package com.djohannes.ac.za.controller.colour;

import com.djohannes.ac.za.domain.Colour;
import com.djohannes.ac.za.service.impl.ColourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/colour")
public class ColourController {

    @Autowired
    private ColourServiceImpl service;

   @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Colour create(@RequestBody Colour colour)
    {
        return service.create(colour);
    }

    @PutMapping("/update")
    @ResponseBody
    public Colour update(@RequestBody Colour colour) {
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

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Colour> getAll() {
        return service.getAll();
    }
}
