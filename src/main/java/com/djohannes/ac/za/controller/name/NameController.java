
package com.djohannes.ac.za.controller.name;


import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/name")
public class NameController {
    @Autowired
    @Qualifier("ServiceImpl")
    private NameService service;

    @PostMapping("/create")
    @ResponseBody
    public Name create(Name name) {
        return service.create(name);
    }

    @PostMapping("/update")
    @ResponseBody
    public Name update(Name name) {
        return service.update(name);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Name read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Name> getAll() {
        return service.getAll();
    }
}