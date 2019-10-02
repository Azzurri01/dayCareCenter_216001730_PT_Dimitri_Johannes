package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.allergy.Allergy;
import java.util.List;

public interface AllergyService extends IService<Allergy, String> {

    List<Allergy> getAll();
}
