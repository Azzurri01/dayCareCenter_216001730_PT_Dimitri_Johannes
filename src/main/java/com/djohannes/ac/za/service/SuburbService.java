package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Suburb;

import java.util.Set;

public interface SuburbService extends IService<Suburb, String> {

    Set<Suburb> getAll();
}
