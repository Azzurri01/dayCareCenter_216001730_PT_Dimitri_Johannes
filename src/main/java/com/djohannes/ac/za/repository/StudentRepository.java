package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Student;
import java.util.HashSet;
import java.util.Set;

public interface StudentRepository extends IRepository<Student, String>
{
    Set<Student> getAll();
}
