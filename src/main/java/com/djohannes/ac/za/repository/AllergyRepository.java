package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Allergy;

import java.util.Set;

public interface AllergyRepository extends IRepository<Allergy, String>
{
    Set<Allergy> getAll();
}
