package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Student;
import com.djohannes.ac.za.repository.StudentRepository;
import com.djohannes.ac.za.repository.impl.StudentRepositoryImpl;
import com.djohannes.ac.za.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {

    private static StudentServiceImpl service = null;

    @Autowired
    @Qualifier("StudentMemory")
    private StudentRepository repository;

    @Override
    public Student create(Student student) {
        return repository.create(student);
    }

    @Override
    public Student update(Student student) {
        return repository.update(student);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Student read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<Student> getAll() {
        return repository.getAll();
    }
}