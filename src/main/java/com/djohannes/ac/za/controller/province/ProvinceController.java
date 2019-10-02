package com.djohannes.ac.za.controller.province;

import com.djohannes.ac.za.domain.Province;
import com.djohannes.ac.za.service.impl.ProvinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Province create(@RequestBody Province province)
    {
        return service.create(province);
    }

    @PutMapping("/update")
    @ResponseBody
    public Province update(@RequestBody Province province) {
        return service.update(province);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Province read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Province> getAll() {
        return service.getAll();
    }
}