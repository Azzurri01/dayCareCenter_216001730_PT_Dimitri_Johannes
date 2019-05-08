package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Account;

import java.util.Set;

public interface AccountRepository extends IRepository<Account, String>
{
    Set<Account> getAll();
}
