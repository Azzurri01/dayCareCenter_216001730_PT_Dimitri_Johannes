package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Alphabet;
import com.djohannes.ac.za.repository.AlphabetRepository;

import java.util.HashSet;
import java.util.Set;

public class AlphabetRepositoryImpl implements AlphabetRepository {

    private static AlphabetRepositoryImpl repository = null;
    private Set<Alphabet> letters;

    private AlphabetRepositoryImpl() {
        this.letters = new HashSet<>();
    }

    private Alphabet findAlphabet(String letterId) {
        /*return this.letters.stream()
                .filter(letter -> letter.getNo().trim().equals(letterId))
                .findAny()
                .orElse(null);*/
        return null;
    }

    public static AlphabetRepositoryImpl getRepository(){
        if(repository == null) repository = new AlphabetRepositoryImpl();
        return repository;
    }

    public Alphabet create(Alphabet letter){
        this.letters.add(letter);
        return letter;
    }

    public Alphabet read(final String letterId){
        //find the student in the set and return it if it exist
        Alphabet letter = findAlphabet(letterId);
        return letter;
    }

    public Alphabet update(Alphabet letter) {
        // find the student, update it and return the updated student
        Alphabet toDelete = findAlphabet(letter.getLetter());
        if(toDelete != null) {
            this.letters.remove(toDelete);
            return create(letter);
        }
        return null;
    }

    public void delete(String letterId) {
        //find the student and delete it if it exists
        Alphabet letter = findAlphabet(letterId);
        if (letter != null) this.letters.remove(letter);
    }

    public Set<Alphabet> getAll(){
        return this.letters;
    }
}
