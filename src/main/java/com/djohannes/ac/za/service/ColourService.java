package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Colour;

import java.util.Set;

public interface ColourService extends IService<Colour, String> {

    Set<Colour> getAll();
}
