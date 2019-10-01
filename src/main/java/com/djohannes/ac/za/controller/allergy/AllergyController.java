package com.djohannes.ac.za.controller.allergy;


import com.djohannes.ac.za.domain.Allergy;
import com.djohannes.ac.za.service.AllergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/dccs/allergy")
public class AllergyController {
    @Autowired
    @Qualifier("AllergyServiceImpl")
    private AllergyService service;

    @PostMapping("/create")
    @ResponseBody
    public Allergy create(@RequestBody Allergy allergy) {
        return service.create(allergy);
    }

    @PostMapping("/update")
    @ResponseBody
    public Allergy update(Allergy allergy) {
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

    @GetMapping("/read/all")
    @ResponseBody
    public List<Allergy> getAll() {
        return service.getAll();
    }
}
