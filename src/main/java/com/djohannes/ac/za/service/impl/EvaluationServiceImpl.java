package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.evaluation.Evaluation;
import com.djohannes.ac.za.repository.EvaluationRepository;
import com.djohannes.ac.za.service.EvaluationService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("EvaluationServiceImpl")
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepository repository;

    @Override
    public Evaluation create(Evaluation evaluation) {
        return this.repository.save(evaluation);
    }

    @Override
    public Evaluation update(Evaluation evaluation) {
        return this.repository.save(evaluation);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Evaluation read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Evaluation> getAll() {
        return this.repository.findAll();
    }

}