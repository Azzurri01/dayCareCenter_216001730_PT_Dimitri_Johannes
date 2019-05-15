package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Account;
import com.djohannes.ac.za.repository.AccountRepository;
import com.djohannes.ac.za.repository.impl.AccountRepositoryImpl;
import com.djohannes.ac.za.service.AccountService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private static AccountServiceImpl service = null;
    private AccountRepository repository;

    private AccountServiceImpl() {
        this.repository = AccountRepositoryImpl.getRepository();
    }

    public static AccountServiceImpl getService(){
        if (service == null) service = new AccountServiceImpl();
        return service;
    }

    @Override
    public Account create(Account account) {
        return this.repository.create(account);
    }

    @Override
    public Account read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Account update(Account account) {
        return this.repository.update(account);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Set<Account> getAll() {
        return this.repository.getAll();
    }
}