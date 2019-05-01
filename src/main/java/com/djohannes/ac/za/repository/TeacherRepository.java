package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Teacher;

import java.util.Set;

public interface TeacherRepository extends IRepository<Teacher, String>
{
    Set<Teacher> getAll();
}