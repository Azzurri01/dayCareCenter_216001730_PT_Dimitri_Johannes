package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Colour;
import com.djohannes.ac.za.domain.Evaluation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColourFactoryTest {

    @Test
    public void getColour()
    {
        Evaluation evaluation = EvaluationFactory.getEvaluation(5);
        Colour colour = ColourFactory.getColour("green",evaluation);
        Assert.assertEquals(5, evaluation.getRating());
        Assert.assertEquals("green", colour.getColour());
    }
}