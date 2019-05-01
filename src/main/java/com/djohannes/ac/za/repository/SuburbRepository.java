package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Suburb;

import java.util.Set;

public interface SuburbRepository extends IRepository<Suburb, String>
{
    Set<Suburb> getAll();
}