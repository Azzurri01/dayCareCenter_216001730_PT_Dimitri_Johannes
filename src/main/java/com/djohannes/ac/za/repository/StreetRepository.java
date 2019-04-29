package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Street;

import java.util.Set;

public interface StreetRepository extends IRepository<Street, String>
{
    Set<Street> getAll();
}