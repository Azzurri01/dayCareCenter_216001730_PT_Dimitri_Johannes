package com.djohannes.ac.za.controller.account;

import com.djohannes.ac.za.domain.Account;
import com.djohannes.ac.za.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account create(@RequestBody Account account)
    {
        return service.create(account);
    }

    @PutMapping("/update")
    @ResponseBody
    public Account update(@RequestBody Account account) {
        return service.update(account);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Account read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> getAll() {
        return service.getAll();
    }
}