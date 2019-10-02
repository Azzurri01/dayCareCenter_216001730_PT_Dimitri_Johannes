package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.grade.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, String>
{

}

