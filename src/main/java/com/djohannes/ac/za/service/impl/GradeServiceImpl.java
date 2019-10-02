package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.repository.GradeRepository;
import com.djohannes.ac.za.service.GradeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("GradeServiceImpl")
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository repository;

    @Override
    public Grade create(Grade grade) {
        return this.repository.save(grade);
    }

    @Override
    public Grade update(Grade grade) {
        return this.repository.save(grade);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Grade read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Grade> getAll() {
        return this.repository.findAll();
    }
}