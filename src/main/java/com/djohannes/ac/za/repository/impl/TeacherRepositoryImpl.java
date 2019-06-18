package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Teacher;
import com.djohannes.ac.za.repository.TeacherRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("TeacherMemory")
public class TeacherRepositoryImpl implements TeacherRepository {

    private static TeacherRepositoryImpl repository = null;
    private Set<Teacher> teachers;

    private TeacherRepositoryImpl() {
        this.teachers = new HashSet<>();
    }

    private Teacher findTeacher(String teacherId) {
        return this.teachers.stream()
                .filter(teacher -> teacher.getId().trim().equals(teacherId))
                .findAny()
                .orElse(null);
    }

    public static TeacherRepositoryImpl getRepository(){
        if(repository == null) repository = new TeacherRepositoryImpl();
        return repository;
    }

    public Teacher create(Teacher teacher){
        this.teachers.add(teacher);
        return teacher;
    }

    public Teacher read(final String teacherId){
        //find the student in the set and return it if it exist
        Teacher teacher = findTeacher(teacherId);
        return teacher;
    }

    public Teacher update(Teacher teacher) {
        // find the student, update it and return the updated student
        Teacher toDelete = findTeacher(teacher.getId());
        if(toDelete != null) {
            this.teachers.remove(toDelete);
            return create(teacher);
        }
        return null;
    }

    public void delete(String teacherId) {
        //find the student and delete it if it exists
        Teacher teacher = findTeacher(teacherId);
        if (teacher != null) this.teachers.remove(teacher);
    }

    public Set<Teacher> getAll(){
        return this.teachers;
    }
}