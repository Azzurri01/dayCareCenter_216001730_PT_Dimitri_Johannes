package com.djohannes.ac.za.controller.allergy;

import com.djohannes.ac.za.domain.Allergy;
import com.djohannes.ac.za.service.impl.AllergyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/allergy")
public class AllergyController {

    @Autowired
    private AllergyServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Allergy create(@RequestBody Allergy allergy)
    {
        return service.create(allergy);
    }

    @PutMapping("/update")
    @ResponseBody
    public Allergy update(@RequestBody Allergy allergy) {
        return service.update(allergy);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Allergy read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Allergy> getAll() {
        return service.getAll();
    }
}