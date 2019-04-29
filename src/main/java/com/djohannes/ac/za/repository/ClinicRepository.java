package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Clinic;

import java.util.Set;

public interface ClinicRepository extends IRepository<Clinic, String>
{
    Set<Clinic> getAll();
}