package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.classroom.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, String>
{

}

