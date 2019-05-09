package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Alphabet;
import com.djohannes.ac.za.domain.Evaluation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphabetFactoryTest {

    @Test
    public void getAlphabet()
    {
        Evaluation evaluation = EvaluationFactory.getEvaluation(5);
        Alphabet alphabet = AlphabetFactory.getAlphabet("a",evaluation);
        Assert.assertEquals(evaluation.getRating(), alphabet.getEvaluation().getRating());
        Assert.assertEquals("a", alphabet.getLetter());
    }
}