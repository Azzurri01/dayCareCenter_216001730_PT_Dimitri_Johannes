package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>
{
    //Set<Student> getAll();
}
