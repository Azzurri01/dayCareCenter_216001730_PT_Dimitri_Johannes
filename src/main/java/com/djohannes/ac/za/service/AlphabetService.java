package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.alphabet.Alphabet;
import java.util.List;

public interface AlphabetService extends IService<Alphabet, String> {

    List<Alphabet> getAll();
}


