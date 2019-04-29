package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Parent;
import com.djohannes.ac.za.repository.ParentRepository;

import java.util.HashSet;
import java.util.Set;

public class ParentRepositoryImpl implements ParentRepository {

    private static ParentRepositoryImpl repository = null;
    private Set<Parent> parents;

    private ParentRepositoryImpl() {
        this.parents = new HashSet<>();
    }

    public static ParentRepository getRepository(){
        if(repository == null) repository = new ParentRepositoryImpl();
        return repository;
    }

    public Parent create(Parent Parent){
        this.parents.add(Parent);
        return Parent;
    }

    public Parent read(String ParentId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Parent update(Parent Parent) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String ParentId) {
        //find the student and delete it if it exists

    }

    public Set<Parent> getAll(){
        return this.parents;
    }
}