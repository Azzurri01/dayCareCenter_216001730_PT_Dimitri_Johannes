package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Meal;
import com.djohannes.ac.za.repository.MealRepository;

import java.util.HashSet;
import java.util.Set;

public class MealRepositoryImpl implements MealRepository {

    private static MealRepositoryImpl repository = null;
    private Set<Meal> meals;

    private MealRepositoryImpl() {
        this.meals = new HashSet<>();
    }

    public static MealRepository getRepository(){
        if(repository == null) repository = new MealRepositoryImpl();
        return repository;
    }

    public Meal create(Meal meal){
        this.meals.add(meal);
        return meal;
    }

    public Meal read(String mealId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Meal update(Meal meal) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String mealId) {
        //find the student and delete it if it exists

    }

    public Set<Meal> getAll(){
        return this.meals;
    }
}