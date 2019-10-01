package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PopulationRepository extends JpaRepository<Population, String>
{
   //Set<Population> getAll();
}