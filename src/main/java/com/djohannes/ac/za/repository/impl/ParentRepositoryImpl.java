package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Parent;
import com.djohannes.ac.za.repository.ParentRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ParentMemory")
public class ParentRepositoryImpl implements ParentRepository {

    private static ParentRepositoryImpl repository = null;
    private Set<Parent> parents;

    private ParentRepositoryImpl() {
        this.parents = new HashSet<>();
    }

    private Parent findParent(String parentId) {
        return this.parents.stream()
                .filter(parent -> parent.getId().trim().equals(parentId))
                .findAny()
                .orElse(null);
    }

    public static ParentRepositoryImpl getRepository(){
        if(repository == null) repository = new ParentRepositoryImpl();
        return repository;
    }

    public Parent create(Parent parent){
        this.parents.add(parent);
        return parent;
    }

    public Parent read(final String parentId){
        //find the student in the set and return it if it exist
        Parent parent = findParent(parentId);
        return parent;
    }

    public Parent update(Parent parent) {
        // find the student, update it and return the updated student
        Parent toDelete = findParent(parent.getId());
        if(toDelete != null) {
            this.parents.remove(toDelete);
            return create(parent);
        }
        return null;
    }

    public void delete(String parentId) {
        //find the student and delete it if it exists
        Parent parent = findParent(parentId);
        if (parent != null) this.parents.remove(parent);
    }

    public Set<Parent> getAll(){
        return this.parents;
    }
}