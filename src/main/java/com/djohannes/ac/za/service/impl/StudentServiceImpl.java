package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Student;
import com.djohannes.ac.za.repository.StudentRepository;
import com.djohannes.ac.za.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student create(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public void delete(String s) {
        repository.deleteById(s);
    }

    @Override
    public Student read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }
}