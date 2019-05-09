package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Alphabet;

import java.util.Set;

public interface AlphabetService extends IService<Alphabet, String> {

    Set<Alphabet> getAll();
}
