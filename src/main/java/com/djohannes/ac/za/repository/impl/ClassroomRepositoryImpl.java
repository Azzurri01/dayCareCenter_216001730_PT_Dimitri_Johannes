package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Classroom;
import com.djohannes.ac.za.repository.ClassroomRepository;

import java.util.HashSet;
import java.util.Set;

public class ClassroomRepositoryImpl implements ClassroomRepository {

    private static ClassroomRepositoryImpl repository = null;
    private Set<Classroom> classrooms;

    private ClassroomRepositoryImpl() {
        this.classrooms = new HashSet<>();
    }

    public static ClassroomRepository getRepository(){
        if(repository == null) repository = new ClassroomRepositoryImpl();
        return repository;
    }

    public Classroom create(Classroom classroom){
        this.classrooms.add(classroom);
        return classroom;
    }

    public Classroom read(String classroomId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Classroom update(Classroom classroom) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String classroomId) {
        //find the student and delete it if it exists

    }

    public Set<Classroom> getAll(){
        return this.classrooms;
    }
}