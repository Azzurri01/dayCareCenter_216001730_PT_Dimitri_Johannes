package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.student.Student;
import com.djohannes.ac.za.repository.StudentRepository;
import com.djohannes.ac.za.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return this.repository.save(student);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Student read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Student> getAll() {
        return this.repository.findAll();
    }
}

