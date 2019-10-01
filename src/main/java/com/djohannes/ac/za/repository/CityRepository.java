package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CityRepository extends JpaRepository<City, String>
{
    //Set<City> getAll();
}