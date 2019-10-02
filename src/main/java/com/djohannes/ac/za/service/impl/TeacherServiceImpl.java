package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Teacher;
import com.djohannes.ac.za.repository.TeacherRepository;
import com.djohannes.ac.za.service.TeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TeacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository repository;

    @Override
    public Teacher create(Teacher teacher) {
        return this.repository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return this.repository.save(teacher);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Teacher read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Teacher> getAll() {
        return this.repository.findAll();
    }
}