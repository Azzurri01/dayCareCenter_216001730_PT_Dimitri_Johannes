package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.evaluation.Evaluation;
import java.util.List;

public interface EvaluationService extends IService<Evaluation, String> {

    List<Evaluation> getAll();
}

