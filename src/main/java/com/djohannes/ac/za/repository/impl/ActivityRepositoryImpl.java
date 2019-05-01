package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Activity;
import com.djohannes.ac.za.repository.ActivityRepository;

import java.util.HashSet;
import java.util.Set;

public class ActivityRepositoryImpl implements ActivityRepository {

    private static ActivityRepositoryImpl repository = null;
    private Set<Activity> activities;

    private ActivityRepositoryImpl() {
        this.activities = new HashSet<>();
    }

    public static ActivityRepository getRepository(){
        if(repository == null) repository = new ActivityRepositoryImpl();
        return repository;
    }

    public Activity create(Activity activity){
        this.activities.add(activity);
        return activity;
    }

    public Activity read(String activityId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Activity update(Activity activity) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String activityId) {
        //find the student and delete it if it exists

    }

    public Set<Activity> getAll(){
        return this.activities;
    }
}
