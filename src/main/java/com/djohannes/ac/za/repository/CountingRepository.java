package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Counting;

import java.util.Set;

public interface CountingRepository extends IRepository<Counting, String>
{
    Set<Counting> getAll();
}