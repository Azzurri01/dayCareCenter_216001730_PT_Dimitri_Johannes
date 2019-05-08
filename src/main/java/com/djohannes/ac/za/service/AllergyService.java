package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Allergy;

import java.util.Set;

public interface AllergyService extends IService<Allergy, String> {

    Set<Allergy> getAll();
}
