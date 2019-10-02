package com.djohannes.ac.za.controller.drawing;

import com.djohannes.ac.za.domain.drawing.Drawing;
import com.djohannes.ac.za.service.impl.DrawingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/drawing")
public class DrawingController {

    @Autowired
    private DrawingServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Drawing create(@RequestBody Drawing drawing)
    {
        return service.create(drawing);
    }

    @PutMapping("/update")
    @ResponseBody
    public Drawing update(@RequestBody Drawing drawing) {
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

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Drawing> getAll() {
        return service.getAll();
    }
}

