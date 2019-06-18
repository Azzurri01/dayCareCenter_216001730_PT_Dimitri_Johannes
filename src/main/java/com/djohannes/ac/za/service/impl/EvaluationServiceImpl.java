package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.repository.EvaluationRepository;
import com.djohannes.ac.za.repository.impl.EvaluationRepositoryImpl;
import com.djohannes.ac.za.service.EvaluationService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("EvaluationServiceImpl")
public class EvaluationServiceImpl implements EvaluationService {

    private static EvaluationServiceImpl service = null;

    @Autowired
    @Qualifier("EvaluationMemory")
    private EvaluationRepository repository;

    private EvaluationServiceImpl() {
        this.repository = EvaluationRepositoryImpl.getRepository();
    }

    public static EvaluationServiceImpl getService(){
        if (service == null) service = new EvaluationServiceImpl();
        return service;
    }

    @Override
    public Evaluation create(Evaluation evaluation) {
        return this.repository.create(evaluation);
    }

    @Override
    public Evaluation update(Evaluation evaluation) {
        return this.repository.update(evaluation);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Evaluation read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Evaluation> getAll() {
        return this.repository.getAll();
    }
}