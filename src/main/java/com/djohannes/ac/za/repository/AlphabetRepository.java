package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Alphabet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AlphabetRepository extends JpaRepository<Alphabet, String>
{
    //Set<Alphabet> getAll();
}
