package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Colour;

import java.util.Set;

public interface ColourRepository extends IRepository<Colour, String>
{
    Set<Colour> getAll();
}