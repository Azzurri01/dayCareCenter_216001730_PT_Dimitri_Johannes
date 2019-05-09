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

    private Grade findGrade(String gradeId) {
        return this.grades.stream()
                .filter(grade -> grade.getId().trim().equals(gradeId))
                .findAny()
                .orElse(null);
    }

    public static GradeRepositoryImpl getRepository(){
        if(repository == null) repository = new GradeRepositoryImpl();
        return repository;
    }

    public Grade create(Grade grade){
        this.grades.add(grade);
        return grade;
    }

    public Grade read(final String gradeId){
        //find the student in the set and return it if it exist
        Grade grade = findGrade(gradeId);
        return grade;
    }

    public Grade update(Grade grade) {
        // find the student, update it and return the updated student
        Grade toDelete = findGrade(grade.getId());
        if(toDelete != null) {
            this.grades.remove(toDelete);
            return create(grade);
        }
        return null;
    }

    public void delete(String gradeId) {
        //find the student and delete it if it exists
        Grade grade = findGrade(gradeId);
        if (grade != null) this.grades.remove(grade);
    }

    public Set<Grade> getAll(){
        return this.grades;
    }
}