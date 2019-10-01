package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Suburb;

import java.util.List;
import java.util.Set;

public interface SuburbService extends IService<Suburb, String> {

    List<Suburb> getAll();
}
