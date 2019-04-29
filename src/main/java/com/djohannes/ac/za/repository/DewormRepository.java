package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Deworm;

import java.util.Set;

public interface DewormRepository extends IRepository<Deworm, String>
{
    Set<Deworm> getAll();
}