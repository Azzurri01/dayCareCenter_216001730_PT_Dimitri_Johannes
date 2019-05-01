package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.City;

import java.util.Set;

public interface CityRepository extends IRepository<City, String>
{
    Set<City> getAll();
}