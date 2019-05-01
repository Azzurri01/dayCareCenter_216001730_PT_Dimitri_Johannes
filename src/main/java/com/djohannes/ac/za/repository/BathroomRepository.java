package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Bathroom;

import java.util.Set;

public interface BathroomRepository extends IRepository<Bathroom, String>
{
    Set<Bathroom> getAll();
}