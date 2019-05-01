package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Payment;
import com.djohannes.ac.za.repository.PaymentRepository;

import java.util.HashSet;
import java.util.Set;

public class PaymentRepositoryImpl implements PaymentRepository {

    private static PaymentRepositoryImpl repository = null;
    private Set<Payment> payments;

    private PaymentRepositoryImpl() {
        this.payments = new HashSet<>();
    }

    public static PaymentRepository getRepository(){
        if(repository == null) repository = new PaymentRepositoryImpl();
        return repository;
    }

    public Payment create(Payment Payment){
        this.payments.add(Payment);
        return Payment;
    }

    public Payment read(String PaymentId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Payment update(Payment Payment) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String PaymentId) {
        //find the student and delete it if it exists

    }

    public Set<Payment> getAll(){
        return this.payments;
    }
}