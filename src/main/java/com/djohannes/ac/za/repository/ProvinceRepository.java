package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Province;

import java.util.Set;

public interface ProvinceRepository extends IRepository<Province, String>
{
    Set<Province> getAll();
}