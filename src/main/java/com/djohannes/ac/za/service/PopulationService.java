package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Population;

import java.util.List;
import java.util.Set;

public interface PopulationService extends IService<Population, String> {

    List<Population> getAll();
}
