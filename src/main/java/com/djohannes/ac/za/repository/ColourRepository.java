package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Colour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColourRepository extends JpaRepository<Colour, String>
{
    //Set<Colour> getAll();
}