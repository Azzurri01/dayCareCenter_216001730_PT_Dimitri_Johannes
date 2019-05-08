package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Student;
import com.djohannes.ac.za.repository.StudentRepository;
import com.djohannes.ac.za.repository.impl.StudentRepositoryImpl;
import com.djohannes.ac.za.service.StudentService;
//import org.springframework.stereotype.Service;


import java.util.Set;

//@Service
public class StudentServiceImpl implements StudentService {

    private static StudentServiceImpl service = null;
    private StudentRepository repository;

    private StudentServiceImpl() {
        this.repository = StudentRepositoryImpl.getRepository();
    }

    public static StudentServiceImpl getService(){
        if (service == null) service = new StudentServiceImpl();
        return service;
    }

    @Override
    public Student create(Student student) {
        return this.repository.create(student);
    }

    @Override
    public Student update(Student student) {
        return this.repository.update(student);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Student read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Student> getAll() {
        return this.repository.getAll();
    }
}