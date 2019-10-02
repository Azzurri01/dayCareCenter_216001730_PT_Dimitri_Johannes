package com.djohannes.ac.za.controller.alphabet;

import com.djohannes.ac.za.domain.Alphabet;
import com.djohannes.ac.za.service.impl.AlphabetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/alphabet")
public class AlphabetController {

    @Autowired
    private AlphabetServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Alphabet create(@RequestBody Alphabet alphabet)
    {
        return service.create(alphabet);
    }

    @PutMapping("/update")
    @ResponseBody
    public Alphabet update(@RequestBody Alphabet alphabet) {
        return service.update(alphabet);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Alphabet read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Alphabet> getAll() {
        return service.getAll();
    }
}