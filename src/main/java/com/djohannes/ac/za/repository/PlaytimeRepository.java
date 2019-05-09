package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Playtime;

import java.util.Set;

public interface PlaytimeRepository extends IRepository<Playtime, String>
{
    Set<Playtime> getAll();
}