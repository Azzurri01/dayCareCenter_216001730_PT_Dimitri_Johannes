package com.djohannes.ac.za.controller.province;


import com.djohannes.ac.za.domain.Province;
import com.djohannes.ac.za.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    @Qualifier("ProvinceServiceImpl")
    private ProvinceService service;

    @PostMapping("/create")
    @ResponseBody
    public Province create(Province province) {
        return service.create(province);
    }

    @PostMapping("/update")
    @ResponseBody
    public Province update(Province province) {
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

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Province> getAll() {
        return service.getAll();
    }
}
