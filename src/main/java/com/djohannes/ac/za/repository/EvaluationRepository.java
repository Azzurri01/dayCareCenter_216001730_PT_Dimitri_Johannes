package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Evaluation;

import java.util.Set;

public interface EvaluationRepository extends IRepository<Evaluation, String>
{
    Set<Evaluation> getAll();
}