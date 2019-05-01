package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Drawing;

import java.util.Set;

public interface DrawingRepository extends IRepository<Drawing, String>
{
    Set<Drawing> getAll();
}