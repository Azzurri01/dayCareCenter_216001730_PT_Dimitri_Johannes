package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DrawingRepository extends JpaRepository<Drawing, String>
{
    //Set<Drawing> getAll();
}