package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Daycare;

import java.util.Set;

public interface DaycareRepository extends IRepository<Daycare, String>
{
    Set<Daycare> getAll();
}