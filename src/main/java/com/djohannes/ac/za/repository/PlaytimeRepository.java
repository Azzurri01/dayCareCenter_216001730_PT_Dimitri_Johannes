package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Playtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PlaytimeRepository extends JpaRepository<Playtime, String>
{
    //Set<Playtime> getAll();
}