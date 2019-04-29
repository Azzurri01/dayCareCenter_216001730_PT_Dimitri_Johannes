package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Excursion;
import com.djohannes.ac.za.repository.ExcursionRepository;

import java.util.HashSet;
import java.util.Set;

public class ExcursionRepositoryImpl implements ExcursionRepository {

    private static ExcursionRepositoryImpl repository = null;
    private Set<Excursion> excursions;

    private ExcursionRepositoryImpl() {
        this.excursions = new HashSet<>();
    }

    public static ExcursionRepository getRepository(){
        if(repository == null) repository = new ExcursionRepositoryImpl();
        return repository;
    }

    public Excursion create(Excursion excursion){
        this.excursions.add(excursion);
        return excursion;
    }

    public Excursion read(String excursionId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Excursion update(Excursion excursion) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String excursionId) {
        //find the student and delete it if it exists

    }

    public Set<Excursion> getAll(){
        return this.excursions;
    }
}