package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Payment;

import java.util.Set;

public interface PaymentRepository extends IRepository<Payment, String>
{
    Set<Payment> getAll();
}