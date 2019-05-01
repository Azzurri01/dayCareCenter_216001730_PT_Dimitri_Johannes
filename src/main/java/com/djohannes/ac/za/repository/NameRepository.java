package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Name;

import java.util.Set;

public interface NameRepository extends IRepository<Name, String>
{
    Set<Name> getAll();
}