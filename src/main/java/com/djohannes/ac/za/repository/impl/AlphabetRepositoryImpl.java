/*package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Alphabet;
import com.djohannes.ac.za.repository.AlphabetRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("AlphabetMemory")
public class AlphabetRepositoryImpl implements AlphabetRepository {

    private static AlphabetRepositoryImpl repository = null;
    private Set<Alphabet> letters;

    private AlphabetRepositoryImpl() {
        this.letters = new HashSet<>();
    }

    private Alphabet findAlphabet(String alphabetId) {
        return this.letters.stream()
                .filter(alphabet -> alphabet.getId().trim().equals(alphabetId))
                .findAny()
                .orElse(null);
    }

    public static AlphabetRepositoryImpl getRepository(){
        if(repository == null) repository = new AlphabetRepositoryImpl();
        return repository;
    }

    public Alphabet create(Alphabet alphabet){
        this.letters.add(alphabet);
        return alphabet;
    }

    public Alphabet read(final String alphabetId){
        //find the student in the set and return it if it exist
        Alphabet alphabet = findAlphabet(alphabetId);
        return alphabet;
    }

    public Alphabet update(Alphabet alphabet) {
        // find the student, update it and return the updated student
        Alphabet toDelete = findAlphabet(alphabet.getId());
        if(toDelete != null) {
            this.letters.remove(toDelete);
            return create(alphabet);
        }
        return null;
    }

    public void delete(String alphabetId) {
        //find the student and delete it if it exists
        Alphabet alphabet = findAlphabet(alphabetId);
        if (alphabet != null) this.letters.remove(alphabet);
    }

    public Set<Alphabet> getAll(){
        return this.letters;
    }
}
*/