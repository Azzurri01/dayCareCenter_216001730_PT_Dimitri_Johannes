package com.djohannes.ac.za.controller.account;


import com.djohannes.ac.za.domain.Account;
import com.djohannes.ac.za.domain.user.ResponseObj;
import com.djohannes.ac.za.factory.AccountFactory;
import com.djohannes.ac.za.factory.ResponseObjFactory;
import com.djohannes.ac.za.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dccs/account")
public class AccountController {
    @Autowired
    @Qualifier("AccountServiceImpl")
    private AccountService service;

    @PostMapping(value = "/create/{account}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Account account) {
        System.out.println("Entered Value: " + account);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Account created!");
        Account savedAccount;
        if (account == null) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a account!");
        } else {
            savedAccount = service.read(account.toString());
            if (savedAccount != null) {
                responseObj.setResponseDescription("Account already exist!");
            } else {
                //savedAccount = AccountFactory.getAccount(account);
                savedAccount = service.create(savedAccount);
            }
            responseObj.setResponse(savedAccount);
        }
        return ResponseEntity.ok(responseObj);
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
