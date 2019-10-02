package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>
{

}

