/*package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Activity;
import com.djohannes.ac.za.repository.ActivityRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ActivityMemory")
public class ActivityRepositoryImpl implements ActivityRepository {

    private static ActivityRepositoryImpl repository = null;
    private Set<Activity> activities;

    private ActivityRepositoryImpl() {
        this.activities = new HashSet<>();
    }

    private Activity findActivity(String activityId) {
        return this.activities.stream()
                .filter(activity -> activity.getId().trim().equals(activityId))
                .findAny()
                .orElse(null);
    }

    public static ActivityRepositoryImpl getRepository(){
        if(repository == null) repository = new ActivityRepositoryImpl();
        return repository;
    }

    public Activity create(Activity activity){
        this.activities.add(activity);
        return activity;
    }

    public Activity read(final String activityId){
        //find the student in the set and return it if it exist
        Activity activity = findActivity(activityId);
        return activity;
    }

    public Activity update(Activity activity) {
        // find the student, update it and return the updated student
        Activity toDelete = findActivity(activity.getId());
        if(toDelete != null) {
            this.activities.remove(toDelete);
            return create(activity);
        }
        return null;
    }

    public void delete(String activityId) {
        //find the student and delete it if it exists
        Activity activity = findActivity(activityId);
        if (activity != null) this.activities.remove(activity);
    }

    public Set<Activity> getAll(){
        return this.activities;
    }
}*/