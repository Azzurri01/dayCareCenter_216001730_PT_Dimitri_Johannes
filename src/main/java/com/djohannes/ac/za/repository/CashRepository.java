package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Cash;

import java.util.Set;

public interface CashRepository extends IRepository<Cash, String>
{
    Set<Cash> getAll();
}
