package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Colour;
import com.djohannes.ac.za.repository.ColourRepository;

import java.util.HashSet;
import java.util.Set;

public class ColourRepositoryImpl implements ColourRepository {

    private static ColourRepositoryImpl repository = null;
    private Set<Colour> colours;

    private ColourRepositoryImpl() {
        this.colours = new HashSet<>();
    }

    private Colour findColour(String colourId) {
        /*return this.colours.stream()
                .filter(colour -> colour.getNo().trim().equals(colourId))
                .findAny()
                .orElse(null);*/
        return null;
    }

    public static ColourRepositoryImpl getRepository(){
        if(repository == null) repository = new ColourRepositoryImpl();
        return repository;
    }

    public Colour create(Colour colour){
        this.colours.add(colour);
        return colour;
    }

    public Colour read(final String colourId){
        //find the student in the set and return it if it exist
        Colour colour = findColour(colourId);
        return colour;
    }

    public Colour update(Colour colour) {
        // find the student, update it and return the updated student
        Colour toDelete = findColour(colour.getColour());
        if(toDelete != null) {
            this.colours.remove(toDelete);
            return create(colour);
        }
        return null;
    }

    public void delete(String colourId) {
        //find the student and delete it if it exists
        Colour colour = findColour(colourId);
        if (colour != null) this.colours.remove(colour);
    }

    public Set<Colour> getAll(){
        return this.colours;
    }
}