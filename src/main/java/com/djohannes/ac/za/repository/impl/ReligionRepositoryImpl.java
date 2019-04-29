package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Religion;
import com.djohannes.ac.za.repository.ReligionRepository;

import java.util.HashSet;
import java.util.Set;

public class ReligionRepositoryImpl implements ReligionRepository {

    private static ReligionRepositoryImpl repository = null;
    private Set<Religion> religions;

    private ReligionRepositoryImpl() {
        this.religions = new HashSet<>();
    }

    public static ReligionRepository getRepository(){
        if(repository == null) repository = new ReligionRepositoryImpl();
        return repository;
    }

    public Religion create(Religion religion){
        this.religions.add(religion);
        return religion;
    }

    public Religion read(String religionId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Religion update(Religion religion) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String religionId) {
        //find the student and delete it if it exists

    }

    public Set<Religion> getAll(){
        return this.religions;
    }
}