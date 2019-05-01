package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Parent;

import java.util.Set;

public interface ParentRepository extends IRepository<Parent, String>
{
    Set<Parent> getAll();
}