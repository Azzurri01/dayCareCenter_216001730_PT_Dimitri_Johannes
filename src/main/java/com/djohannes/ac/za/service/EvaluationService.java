package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Evaluation;

import java.util.List;
import java.util.Set;

public interface EvaluationService extends IService<Evaluation, String> {

    List<Evaluation> getAll();
}
