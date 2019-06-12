package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Student;
import com.djohannes.ac.za.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("StudentMemory")
public class StudentRepositoryImpl implements StudentRepository {
    private static StudentRepositoryImpl repository = null;
    private Map<String, Student> students;

    private StudentRepositoryImpl() {
        this.students = new HashMap<>();
    }

    public static StudentRepositoryImpl getRepository() {
        if (repository == null) repository = new StudentRepositoryImpl();
        return repository;
    }

    public Student create(Student student) {
        this.students.put(student.getId(), student);
        return student;
    }

    public Student read(String studentId) {
        return this.students.get(studentId);
    }

    public Student update(Student student) {
        this.students.replace(student.getId(), student);
        return this.students.get(student.getId());
    }

    public void delete(String studentId) {
        this.students.remove(studentId);
    }

    public Set<Student> getAll() {
        Collection<Student> students = this.students.values();
        Set<Student> set = new HashSet<>();
        set.addAll(students);
        return set;
    }
}