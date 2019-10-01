package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Allergy;

import java.util.List;
import java.util.Set;

public interface AllergyService extends IService<Allergy, String> {

    List<Allergy> getAll();
}
