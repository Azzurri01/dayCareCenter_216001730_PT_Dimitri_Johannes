package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Grade;

import java.util.Set;

public interface GradeRepository extends IRepository<Grade, String>
{
    Set<Grade> getAll();
}