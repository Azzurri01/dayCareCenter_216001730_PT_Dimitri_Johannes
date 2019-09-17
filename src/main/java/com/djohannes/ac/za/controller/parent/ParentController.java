package com.djohannes.ac.za.controller.parent;


import com.djohannes.ac.za.domain.Parent;
import com.djohannes.ac.za.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("dccs/parent")
public class ParentController {
    @Autowired
    @Qualifier("ParentServiceImpl")
    private ParentService service;

    @PostMapping("/create")
    @ResponseBody
    public Parent create(@RequestBody Parent parent) {
        return service.create(parent);
    }

    @PostMapping("/update")
    @ResponseBody
    public Parent update(Parent parent) {
        return service.update(parent);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Parent read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Parent> getAll() {
        return service.getAll();
    }
}
