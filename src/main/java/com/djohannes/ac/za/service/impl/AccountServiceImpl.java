package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Account;
import com.djohannes.ac.za.repository.AccountRepository;
import com.djohannes.ac.za.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AccountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

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