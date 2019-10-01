package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Counting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CountingRepository extends JpaRepository<Counting, String>
{
    //Set<Counting> getAll();
}