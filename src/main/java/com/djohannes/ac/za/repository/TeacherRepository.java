package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String>
{

}

