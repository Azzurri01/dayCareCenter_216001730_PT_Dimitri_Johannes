package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Cash;
import com.djohannes.ac.za.repository.CashRepository;

import java.util.HashSet;
import java.util.Set;

public class CashRepositoryImpl implements CashRepository {

    private static CashRepositoryImpl repository = null;
    private Set<Cash> cashPayments;

    private CashRepositoryImpl() {
        this.cashPayments = new HashSet<>();
    }

    public static CashRepository getRepository(){
        if(repository == null) repository = new CashRepositoryImpl();
        return repository;
    }

    public Cash create(Cash cash){
        this.cashPayments.add(cash);
        return cash;
    }

    public Cash read(String cashId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Cash update(Cash cash) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String cashId) {
        //find the student and delete it if it exists

    }

    public Set<Cash> getAll(){
        return this.cashPayments;
    }
}