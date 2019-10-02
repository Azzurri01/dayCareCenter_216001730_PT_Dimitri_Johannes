package com.djohannes.ac.za.controller.contact;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.service.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Contact create(@RequestBody Contact contact)
    {
        return service.create(contact);
    }

    @PutMapping("/update")
    @ResponseBody
    public Contact update(@RequestBody Contact contact) {
        return service.update(contact);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Contact read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> getAll() {
        return service.getAll();
    }
}
