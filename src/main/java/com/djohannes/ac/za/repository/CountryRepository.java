package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Country;

import java.util.Set;

public interface CountryRepository extends IRepository<Country, String>
{
    Set<Country> getAll();
}