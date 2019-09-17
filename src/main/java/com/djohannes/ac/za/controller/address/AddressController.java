package com.djohannes.ac.za.controller.address;


import com.djohannes.ac.za.domain.Address;
import com.djohannes.ac.za.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dccs/address")
public class AddressController {
    @Autowired
    @Qualifier("AddressServiceImpl")
    private AddressService service;

    @PostMapping("/create")
    @ResponseBody
    public Address create(@RequestBody Address address) {
        return service.create(address);
    }

    @PostMapping("/update")
    @ResponseBody
    public Address update(Address address) {
        return service.update(address);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Address read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Address> getAll() {
        return service.getAll();
    }
}