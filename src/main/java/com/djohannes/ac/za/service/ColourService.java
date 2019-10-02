package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.colour.Colour;

import java.util.List;

public interface ColourService extends IService<Colour, String> {
    List<Colour> getAll();
}
