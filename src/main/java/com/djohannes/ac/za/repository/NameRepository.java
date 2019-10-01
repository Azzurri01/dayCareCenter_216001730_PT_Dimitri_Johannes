package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface NameRepository extends JpaRepository<Name, String>
{
    //Set<Name> getAll();
}