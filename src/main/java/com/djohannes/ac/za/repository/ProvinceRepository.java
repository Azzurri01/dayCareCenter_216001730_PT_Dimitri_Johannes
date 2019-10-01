package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String>
{
    //Set<Province> getAll();
}