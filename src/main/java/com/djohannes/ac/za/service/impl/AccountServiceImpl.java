package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Account;
import com.djohannes.ac.za.repository.AccountRepository;
//import com.djohannes.ac.za.repository.impl.AccountRepositoryImpl;
import com.djohannes.ac.za.service.AccountService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("AccountServiceImpl")
public class AccountServiceImpl implements AccountService {

    private static AccountServiceImpl service = null;

    @Autowired
    //@Qualifier("AccountMemory")
    private AccountRepository repository;

    public static AccountServiceImpl getService(){
        if (service == null) service = new AccountServiceImpl();
        return service;
    }

    @Override
    public Account create(Account account) {
        return this.repository.save(account);
    }

    @Override
    public Account read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Account update(Account account) {
        return this.repository.save(account);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public List<Account> getAll() {
        return this.repository.findAll();
    }
}