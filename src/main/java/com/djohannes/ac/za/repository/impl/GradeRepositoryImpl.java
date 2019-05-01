package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.repository.GradeRepository;

import java.util.HashSet;
import java.util.Set;

public class GradeRepositoryImpl implements GradeRepository {

    private static GradeRepositoryImpl repository = null;
    private Set<Grade> grades;

    private GradeRepositoryImpl() {
        this.grades = new HashSet<>();
    }

    public static GradeRepository getRepository(){
        if(repository == null) repository = new GradeRepositoryImpl();
        return repository;
    }

    public Grade create(Grade grade){
        this.grades.add(grade);
        return grade;
    }

    public Grade read(String gradeId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Grade update(Grade grade) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String gradeId) {
        //find the student and delete it if it exists

    }

    public Set<Grade> getAll(){
        return this.grades;
    }
}