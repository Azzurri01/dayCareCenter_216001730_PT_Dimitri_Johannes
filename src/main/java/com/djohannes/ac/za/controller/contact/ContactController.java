package com.djohannes.ac.za.controller.contact;


import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.factory.ContactFactory;
import com.djohannes.ac.za.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/dccs/contact")
public class ContactController {
    @Autowired
    @Qualifier("ContactServiceImpl")
    private ContactService service;

    @PostMapping("/create")
    @ResponseBody
    public Contact create(@RequestBody Contact contact)
    {
        return service.create(contact);
    }

    /*@PostMapping("/create")
    @ResponseBody
    public Contact create(@RequestBody String tel, @RequestBody String email)
    {
        Contact contact = ContactFactory.getContact(tel, email);
        return service.create(contact);
    }*/

    @PostMapping("/update")
    @ResponseBody
    public Contact update(Contact contact) {
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

    @GetMapping("/read/all")
    @ResponseBody
    public List<Contact> getAll() {
        return service.getAll();
    }
}
