package com.djohannes.ac.za.controller.account;


import com.djohannes.ac.za.domain.Account;
import com.djohannes.ac.za.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    @Qualifier("AccountServiceImpl")
    private AccountService service;

    @PostMapping("/create")
    @ResponseBody
    public Account create(Account account) {
        return service.create(account);
    }

    @PostMapping("/update")
    @ResponseBody
    public Account update(Account account) {
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

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Account> getAll() {
        return service.getAll();
    }
}
