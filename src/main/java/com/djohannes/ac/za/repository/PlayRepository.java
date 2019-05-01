package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Play;

import java.util.Set;

public interface PlayRepository extends IRepository<Play, String>
{
    Set<Play> getAll();
}