package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Learning;

import java.util.Set;

public interface LearningRepository extends IRepository<Learning, String>
{
    Set<Learning> getAll();
}