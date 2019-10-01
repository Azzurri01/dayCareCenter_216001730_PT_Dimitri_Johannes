package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Alphabet;

import java.util.List;
import java.util.Set;

public interface AlphabetService extends IService<Alphabet, String> {

    List<Alphabet> getAll();
}
