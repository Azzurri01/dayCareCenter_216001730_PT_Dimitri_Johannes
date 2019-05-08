package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Population;

import java.util.Set;

public interface PopulationService extends IService<Population, String> {

    Set<Population> getAll();
}
