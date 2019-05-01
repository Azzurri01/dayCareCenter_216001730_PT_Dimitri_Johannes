package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Excursion;

import java.util.Set;

public interface ExcursionRepository extends IRepository<Excursion, String>
{
    Set<Excursion> getAll();
}