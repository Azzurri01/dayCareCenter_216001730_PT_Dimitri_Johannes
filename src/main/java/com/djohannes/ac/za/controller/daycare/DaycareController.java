package com.djohannes.ac.za.controller.daycare;


import com.djohannes.ac.za.domain.Daycare;
import com.djohannes.ac.za.factory.DaycareFactory;
import com.djohannes.ac.za.service.DaycareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/daycare")
public class DaycareController {
    @Autowired
    @Qualifier("DaycareServiceImpl")
    private DaycareService service;

    @PostMapping("/create")
    @ResponseBody
   public Daycare create(@RequestBody Daycare daycare) {
        return service.create(daycare);
    }

    @PostMapping("/update")
    @ResponseBody
    public Daycare update(Daycare daycare) {
        return service.update(daycare);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Daycare read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Daycare> getAll() {
        return service.getAll();
    }
}