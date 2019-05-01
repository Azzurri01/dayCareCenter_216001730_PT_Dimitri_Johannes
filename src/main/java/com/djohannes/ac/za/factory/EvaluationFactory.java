package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Evaluation;

public class EvaluationFactory
{
    public static Evaluation getEvaluation(int mark)
    {
        return new Evaluation.Builder()
                .rating(mark)
                .build();
    }
}
