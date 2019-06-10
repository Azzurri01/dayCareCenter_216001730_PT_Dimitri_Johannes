package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Teacher;
import com.djohannes.ac.za.repository.TeacherRepository;
import com.djohannes.ac.za.repository.impl.TeacherRepositoryImpl;
import com.djohannes.ac.za.service.TeacherService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("TeacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {

    private static TeacherServiceImpl service = null;

    @Autowired
    @Qualifier("TeacherMemory")
    private TeacherRepository repository;

    private TeacherServiceImpl() {
        this.repository = TeacherRepositoryImpl.getRepository();
    }

    public static TeacherServiceImpl getService(){
        if (service == null) service = new TeacherServiceImpl();
        return service;
    }

    @Override
    public Teacher create(Teacher teacher) {
        return this.repository.create(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return this.repository.update(teacher);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Teacher read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Teacher> getAll() {
        return this.repository.getAll();
    }
}