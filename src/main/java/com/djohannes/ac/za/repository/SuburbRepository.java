package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Suburb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SuburbRepository extends JpaRepository<Suburb, String>
{
    //Set<Suburb> getAll();
}