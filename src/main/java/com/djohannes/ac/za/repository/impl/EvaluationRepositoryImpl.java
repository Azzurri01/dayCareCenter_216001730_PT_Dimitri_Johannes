package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.repository.EvaluationRepository;

import java.util.HashSet;
import java.util.Set;

public class EvaluationRepositoryImpl implements EvaluationRepository {

    private static EvaluationRepositoryImpl repository = null;
    private Set<Evaluation> evaluations;

    private EvaluationRepositoryImpl() {
        this.evaluations = new HashSet<>();
    }

    private Evaluation findEvaluation(String evaluationId) {
        return this.evaluations.stream()
                .filter(evaluation -> evaluation.getId().trim().equals(evaluationId))
                .findAny()
                .orElse(null);
    }

    public static EvaluationRepositoryImpl getRepository(){
        if(repository == null) repository = new EvaluationRepositoryImpl();
        return repository;
    }

    public Evaluation create(Evaluation evaluation){
        this.evaluations.add(evaluation);
        return evaluation;
    }

    public Evaluation read(final String evaluationId){
        //find the student in the set and return it if it exist
        Evaluation evaluation = findEvaluation(evaluationId);
        return evaluation;
    }

    public Evaluation update(Evaluation evaluation) {
        // find the student, update it and return the updated student
        Evaluation toDelete = findEvaluation(evaluation.getId());
        if(toDelete != null) {
            this.evaluations.remove(toDelete);
            return create(evaluation);
        }
        return null;
    }

    public void delete(String evaluationId) {
        //find the student and delete it if it exists
        Evaluation evaluation = findEvaluation(evaluationId);
        if (evaluation != null) this.evaluations.remove(evaluation);
    }

    public Set<Evaluation> getAll(){
        return this.evaluations;
    }
}