package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Religion;

import java.util.Set;

public interface ReligionRepository extends IRepository<Religion, String>
{
    Set<Religion> getAll();
}