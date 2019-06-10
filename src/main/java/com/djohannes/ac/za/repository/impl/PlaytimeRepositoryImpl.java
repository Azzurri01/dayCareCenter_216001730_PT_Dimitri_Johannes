package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Playtime;
import com.djohannes.ac.za.repository.PlaytimeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("PlaytimeMemory")
public class PlaytimeRepositoryImpl implements PlaytimeRepository {

    private static PlaytimeRepositoryImpl repository = null;
    private Set<Playtime> numbers;

    private PlaytimeRepositoryImpl() {
        this.numbers = new HashSet<>();
    }

    private Playtime findPlaytime(String playtimeId) {
        return this.numbers.stream()
                .filter(playtime -> playtime.getId().trim().equals(playtimeId))
                .findAny()
                .orElse(null);
    }

    public static PlaytimeRepositoryImpl getRepository(){
        if(repository == null) repository = new PlaytimeRepositoryImpl();
        return repository;
    }

    public Playtime create(Playtime playtime){
        this.numbers.add(playtime);
        return playtime;
    }

    public Playtime read(final String playtimeId){
        //find the student in the set and return it if it exist
        Playtime playtime = findPlaytime(playtimeId);
        return playtime;
    }

    public Playtime update(Playtime playtime) {
        // find the student, update it and return the updated student
        Playtime toDelete = findPlaytime(playtime.getId());
        if(toDelete != null) {
            this.numbers.remove(toDelete);
            return create(playtime);
        }
        return null;
    }

    public void delete(String playtimeId) {
        //find the student and delete it if it exists
        Playtime playtime = findPlaytime(playtimeId);
        if (playtime != null) this.numbers.remove(playtime);
    }

    public Set<Playtime> getAll(){
        return this.numbers;
    }
}