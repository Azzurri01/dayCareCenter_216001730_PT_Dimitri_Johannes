package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String>
{
    //Set<Teacher> getAll();
}