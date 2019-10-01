package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, String>
{
    //Set<Allergy> getAll();
}
