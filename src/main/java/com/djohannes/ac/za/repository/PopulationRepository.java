package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Population;

import java.util.Set;

public interface PopulationRepository extends IRepository<Population, String>
{
    Set<Population> getAll();
}