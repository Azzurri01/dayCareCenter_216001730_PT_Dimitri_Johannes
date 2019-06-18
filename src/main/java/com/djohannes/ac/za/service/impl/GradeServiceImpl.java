package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.repository.GradeRepository;
import com.djohannes.ac.za.repository.impl.GradeRepositoryImpl;
import com.djohannes.ac.za.service.GradeService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("GradeServiceImpl")
public class GradeServiceImpl implements GradeService {

    private static GradeServiceImpl service = null;

    @Autowired
    @Qualifier("GradeMemory")
    private GradeRepository repository;

    private GradeServiceImpl() {
        this.repository = GradeRepositoryImpl.getRepository();
    }

    public static GradeServiceImpl getService(){
        if (service == null) service = new GradeServiceImpl();
        return service;
    }

    @Override
    public Grade create(Grade grade) {
        return this.repository.create(grade);
    }

    @Override
    public Grade update(Grade grade) {
        return this.repository.update(grade);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Grade read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Grade> getAll() {
        return this.repository.getAll();
    }
}