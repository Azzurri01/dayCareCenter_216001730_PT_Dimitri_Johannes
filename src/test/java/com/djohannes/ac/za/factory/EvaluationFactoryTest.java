package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Evaluation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluationFactoryTest {

    @Test
    public void getEvaluation()
    {
        Evaluation evaluation = EvaluationFactory.getEvaluation(7);
        Assert.assertNotNull(evaluation.getId());
        Assert.assertEquals(7, evaluation.getRating());
    }
}