package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Classroom;
import com.djohannes.ac.za.repository.ClassroomRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ClassroomMemory")
public class ClassroomRepositoryImpl implements ClassroomRepository {

    private static ClassroomRepositoryImpl repository = null;
    private Set<Classroom> classrooms;

    private ClassroomRepositoryImpl() {
        this.classrooms = new HashSet<>();
    }

    private Classroom findClassroom(String classroomId) {
        return this.classrooms.stream()
                .filter(classroom -> classroom.getId().trim().equals(classroomId))
                .findAny()
                .orElse(null);
    }

    public static ClassroomRepositoryImpl getRepository(){
        if(repository == null) repository = new ClassroomRepositoryImpl();
        return repository;
    }

    public Classroom create(Classroom classroom){
        this.classrooms.add(classroom);
        return classroom;
    }

    public Classroom read(final String classroomId){
        //find the student in the set and return it if it exist
        Classroom classroom = findClassroom(classroomId);
        return classroom;
    }

    public Classroom update(Classroom classroom) {
        // find the student, update it and return the updated student
        Classroom toDelete = findClassroom(classroom.getId());
        if(toDelete != null) {
            this.classrooms.remove(toDelete);
            return create(classroom);
        }
        return null;
    }

    public void delete(String classroomId) {
        //find the student and delete it if it exists
        Classroom classroom = findClassroom(classroomId);
        if (classroom != null) this.classrooms.remove(classroom);
    }

    public Set<Classroom> getAll(){
        return this.classrooms;
    }
}