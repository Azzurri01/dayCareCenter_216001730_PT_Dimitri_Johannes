package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Account;

import java.util.Set;

public interface AccountService extends IService<Account, String> {

    Set<Account> getAll();
}