package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Play;
import com.djohannes.ac.za.repository.PlaytimeRepository;

import java.util.HashSet;
import java.util.Set;

public class PlayRepositoryImpl implements PlaytimeRepository {

    private static PlayRepositoryImpl repository = null;
    private Set<Play> playActivities;

    private PlayRepositoryImpl() {
        this.playActivities = new HashSet<>();
    }

    public static PlaytimeRepository getRepository(){
        if(repository == null) repository = new PlayRepositoryImpl();
        return repository;
    }

    public Play create(Play play){
        this.playActivities.add(play);
        return play;
    }

    public Play read(String playId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Play update(Play play) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String playId) {
        //find the student and delete it if it exists

    }

    public Set<Play> getAll(){
        return this.playActivities;
    }
}