package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Account;
import com.djohannes.ac.za.repository.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("AccountMemory")
public class AccountRepositoryImpl implements AccountRepository {

    private static AccountRepositoryImpl repository = null;
    private Set<Account> accounts;

    private AccountRepositoryImpl() {
        this.accounts = new HashSet<>();
    }

    private Account findAccount(String accountId) {
        return this.accounts.stream()
                .filter(account -> account.getId().trim().equals(accountId))
                .findAny()
                .orElse(null);
    }

    public static AccountRepositoryImpl getRepository(){
        if(repository == null) repository = new AccountRepositoryImpl();
        return repository;
    }

    public Account create(Account account){
        this.accounts.add(account);
        return account;
    }

    public Account read(final String accountId){
        //find the student in the set and return it if it exist
        Account account = findAccount(accountId);
        return account;
    }

    public Account update(Account account) {
        // find the student, update it and return the updated student
        Account toDelete = findAccount(account.getId());
        if(toDelete != null) {
            this.accounts.remove(toDelete);
            return create(account);
        }
        return null;
    }

    public void delete(String accountId) {
        //find the student and delete it if it exists
        Account account = findAccount(accountId);
        if (account != null) this.accounts.remove(account);
    }

    public Set<Account> getAll(){
        return this.accounts;
    }
}