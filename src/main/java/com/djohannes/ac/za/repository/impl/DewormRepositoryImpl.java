package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Deworm;
import com.djohannes.ac.za.repository.DewormRepository;

import java.util.HashSet;
import java.util.Set;

public class DewormRepositoryImpl implements DewormRepository {

    private static DewormRepositoryImpl repository = null;
    private Set<Deworm> injections;

    private DewormRepositoryImpl() {
        this.injections = new HashSet<>();
    }

    public static DewormRepository getRepository(){
        if(repository == null) repository = new DewormRepositoryImpl();
        return repository;
    }

    public Deworm create(Deworm injection){
        this.injections.add(injection);
        return injection;
    }

    public Deworm read(String injectionId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Deworm update(Deworm injection) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String injectionId) {
        //find the student and delete it if it exists

    }

    public Set<Deworm> getAll(){
        return this.injections;
    }
}