package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Bathroom;
import com.djohannes.ac.za.repository.BathroomRepository;

import java.util.HashSet;
import java.util.Set;

public class BathroomRepositoryImpl implements BathroomRepository {

    private static BathroomRepositoryImpl repository = null;
    private Set<Bathroom> bathrooms;

    private BathroomRepositoryImpl() {
        this.bathrooms = new HashSet<>();
    }

    public static BathroomRepository getRepository(){
        if(repository == null) repository = new BathroomRepositoryImpl();
        return repository;
    }

    public Bathroom create(Bathroom bathroom){
        this.bathrooms.add(bathroom);
        return bathroom;
    }

    public Bathroom read(String bathroomId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Bathroom update(Bathroom bathroom) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String bathroomId) {
        //find the student and delete it if it exists
    }

    public Set<Bathroom> getAll(){
        return this.bathrooms;
    }
}