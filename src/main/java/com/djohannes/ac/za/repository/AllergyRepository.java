package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.allergy.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, String>
{

}

