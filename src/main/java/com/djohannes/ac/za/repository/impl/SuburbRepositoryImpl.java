package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Suburb;
import com.djohannes.ac.za.repository.SuburbRepository;

import java.util.HashSet;
import java.util.Set;

public class SuburbRepositoryImpl implements SuburbRepository {

    private static SuburbRepositoryImpl repository = null;
    private Set<Suburb> suburbs;

    private SuburbRepositoryImpl() {
        this.suburbs = new HashSet<>();
    }

    public static SuburbRepository getRepository(){
        if(repository == null) repository = new SuburbRepositoryImpl();
        return repository;
    }

    public Suburb create(Suburb suburb){
        this.suburbs.add(suburb);
        return suburb;
    }

    public Suburb read(String suburbId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Suburb update(Suburb suburb) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String suburbId) {
        //find the student and delete it if it exists

    }

    public Set<Suburb> getAll(){
        return this.suburbs;
    }
}