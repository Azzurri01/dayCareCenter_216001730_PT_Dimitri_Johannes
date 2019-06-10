package com.djohannes.ac.za.controller.drawing;


import com.djohannes.ac.za.domain.Drawing;
import com.djohannes.ac.za.service.DrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/drawing")
public class DrawingController {
    @Autowired
    @Qualifier("DrawingServiceImpl")
    private DrawingService service;

    @PostMapping("/create")
    @ResponseBody
    public Drawing create(Drawing drawing) {
        return service.create(drawing);
    }

    @PostMapping("/update")
    @ResponseBody
    public Drawing update(Drawing drawing) {
        return service.update(drawing);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Drawing read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Drawing> getAll() {
        return service.getAll();
    }
}
