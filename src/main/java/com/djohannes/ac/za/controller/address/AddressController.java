package com.djohannes.ac.za.controller.address;

import com.djohannes.ac.za.domain.Address;
import com.djohannes.ac.za.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Address create(@RequestBody Address address)
    {
        return service.create(address);
    }

    @PutMapping("/update")
    @ResponseBody
    public Address update(@RequestBody Address address) {
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

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Address> getAll() {
        return service.getAll();
    }
}