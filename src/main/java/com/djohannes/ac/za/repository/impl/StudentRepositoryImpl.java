package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Student;
import com.djohannes.ac.za.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("StudentMemory")
public class StudentRepositoryImpl implements StudentRepository
{
    //Local variables
    private static StudentRepositoryImpl repository = null;
    private Set<Student> students;

    //Default constructor
    private StudentRepositoryImpl()
    {
        this.students = new HashSet<>();
    }

    //Get repository
    public static StudentRepositoryImpl getRepository()
    {
        if(repository == null) repository = new StudentRepositoryImpl();
        return repository;
    }

    //Search for student
    private Student search(String studentId)
    {
        return this.students.stream()
                .filter(student -> student.getId().trim().equals(studentId))
                .findAny()
                .orElse(null);
    }

    //Create student object
    public Student create(Student student)
    {
        this.students.add(student);
        return student;
    }

    //Read student object
    public Student read(String studentId)
    {
        //find the student in the set and return it if it exist
        Student student = search(studentId);
        return student;
    }

    //Update student object
    public Student update(Student student)
    {
        // find the student, update it and return the updated student
        Student studentDelete = search(student.getId());
        if(studentDelete != null) {
            this.students.remove(studentDelete);
            return create(student);
        }
        return null;
    }

    //Delete student object
    public void delete(String studentId)
    {
        //find the student and delete it if it exists
        Student student = search(studentId);
        if (student != null)
            this.students.remove(student);
    }

    //Get All
    public Set<Student> getAll()
    {
        return this.students;
    }
}
