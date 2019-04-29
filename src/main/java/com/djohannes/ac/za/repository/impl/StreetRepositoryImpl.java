package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Street;
import com.djohannes.ac.za.repository.StreetRepository;

import java.util.HashSet;
import java.util.Set;

public class StreetRepositoryImpl implements StreetRepository {

    private static StreetRepositoryImpl repository = null;
    private Set<Street> streets;

    private StreetRepositoryImpl() {
        this.streets = new HashSet<>();
    }

    public static StreetRepository getRepository(){
        if(repository == null) repository = new StreetRepositoryImpl();
        return repository;
    }

    public Street create(Street street){
        this.streets.add(street);
        return street;
    }

    public Street read(String streetId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Street update(Street street) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String streetId) {
        //find the student and delete it if it exists

    }

    public Set<Street> getAll(){
        return this.streets;
    }
}