package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Classroom;
import com.djohannes.ac.za.repository.ClassroomRepository;
//import com.djohannes.ac.za.repository.impl.ClassroomRepositoryImpl;
import com.djohannes.ac.za.service.ClassroomService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ClassroomServiceImpl")
public class ClassroomServiceImpl implements ClassroomService {

    private static ClassroomServiceImpl service = null;

    @Autowired
    //@Qualifier("ClassroomMemory")
    private ClassroomRepository repository;

    public static ClassroomServiceImpl getService(){
        if (service == null) service = new ClassroomServiceImpl();
        return service;
    }

    @Override
    public Classroom create(Classroom classroom) {
        return this.repository.save(classroom);
    }

    @Override
    public Classroom update(Classroom classroom) {
        return this.repository.save(classroom);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Classroom read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Classroom> getAll() {
        return this.repository.findAll();
    }
}