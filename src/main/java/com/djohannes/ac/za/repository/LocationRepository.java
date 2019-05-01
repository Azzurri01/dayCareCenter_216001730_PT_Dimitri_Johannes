package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Location;

import java.util.Set;

public interface LocationRepository extends IRepository<Location, String>
{
    Set<Location> getAll();
}