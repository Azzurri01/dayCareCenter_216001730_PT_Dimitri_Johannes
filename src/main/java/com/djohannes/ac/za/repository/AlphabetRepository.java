package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Alphabet;

import java.util.Set;

public interface AlphabetRepository extends IRepository<Alphabet, String>
{
    Set<Alphabet> getAll();
}
