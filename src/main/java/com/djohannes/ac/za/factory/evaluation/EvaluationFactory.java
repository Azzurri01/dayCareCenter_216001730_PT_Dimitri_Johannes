package com.djohannes.ac.za.factory.evaluation;

import com.djohannes.ac.za.domain.evaluation.Evaluation;
import com.djohannes.ac.za.util.Misc;

public class EvaluationFactory
{
    public static Evaluation getEvaluation(int mark)
    {
        return new Evaluation.Builder()
                .id(Misc.generateId())
                .rating(mark)
                .build();
    }
}

