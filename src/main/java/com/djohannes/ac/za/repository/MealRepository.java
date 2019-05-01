package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Meal;

import java.util.Set;

public interface MealRepository extends IRepository<Meal, String>
{
    Set<Meal> getAll();
}