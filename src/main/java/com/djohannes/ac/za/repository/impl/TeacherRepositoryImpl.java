package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Teacher;
import com.djohannes.ac.za.repository.TeacherRepository;

import java.util.HashSet;
import java.util.Set;

public class TeacherRepositoryImpl implements TeacherRepository {

    private static TeacherRepositoryImpl repository = null;
    private Set<Teacher> teachers;

    private TeacherRepositoryImpl() {
        this.teachers = new HashSet<>();
    }

    public static TeacherRepository getRepository(){
        if(repository == null) repository = new TeacherRepositoryImpl();
        return repository;
    }

    public Teacher create(Teacher teacher){
        this.teachers.add(teacher);
        return teacher;
    }

    public Teacher read(String teacherId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Teacher update(Teacher teacher) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String teacherId) {
        //find the student and delete it if it exists

    }

    public Set<Teacher> getAll(){
        return this.teachers;
    }
}