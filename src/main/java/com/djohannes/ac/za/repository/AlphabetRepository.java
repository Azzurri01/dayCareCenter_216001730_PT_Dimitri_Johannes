package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.alphabet.Alphabet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphabetRepository extends JpaRepository<Alphabet, String>
{

}


