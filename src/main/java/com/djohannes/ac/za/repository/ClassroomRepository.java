package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Classroom;

import java.util.Set;

public interface ClassroomRepository extends IRepository<Classroom, String>
{
    Set<Classroom> getAll();
}