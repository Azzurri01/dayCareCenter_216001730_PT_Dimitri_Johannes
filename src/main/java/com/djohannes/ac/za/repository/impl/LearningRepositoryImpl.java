package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Learning;
import com.djohannes.ac.za.repository.LearningRepository;

import java.util.HashSet;
import java.util.Set;

public class LearningRepositoryImpl implements LearningRepository {

    private static LearningRepositoryImpl repository = null;
    private Set<Learning> learningActivities;

    private LearningRepositoryImpl() {
        this.learningActivities = new HashSet<>();
    }

    public static LearningRepository getRepository(){
        if(repository == null) repository = new LearningRepositoryImpl();
        return repository;
    }

    public Learning create(Learning learning){
        this.learningActivities.add(learning);
        return learning;
    }

    public Learning read(String learningId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Learning update(Learning learning) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String learningId) {
        //find the student and delete it if it exists

    }

    public Set<Learning> getAll(){
        return this.learningActivities;
    }
}