package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Student;
import com.djohannes.ac.za.repository.StudentRepository;

import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryImpl implements StudentRepository {

    private static StudentRepositoryImpl repository = null;
    private Set<Student> students;

    private StudentRepositoryImpl() {
        this.students = new HashSet<>();
    }

    private Student findStudent(String studentId) {
        /*return this.students.stream()
                .filter(student -> student.getNo().trim().equals(studentId))
                .findAny()
                .orElse(null);*/
        return null;
    }

    public static StudentRepositoryImpl getRepository(){
        if(repository == null) repository = new StudentRepositoryImpl();
        return repository;
    }

    public Student create(Student student){
        this.students.add(student);
        return student;
    }

    public Student read(final String studentId){
        //find the student in the set and return it if it exist
        Student student = findStudent(studentId);
        return student;
    }

    public Student update(Student student) {
        // find the student, update it and return the updated student
        Student toDelete = findStudent(student.getId());
        if(toDelete != null) {
            this.students.remove(toDelete);
            return create(student);
        }
        return null;
    }

    public void delete(String studentId) {
        //find the student and delete it if it exists
        Student student = findStudent(studentId);
        if (student != null) this.students.remove(student);
    }

    public Set<Student> getAll(){
        return this.students;
    }
}
