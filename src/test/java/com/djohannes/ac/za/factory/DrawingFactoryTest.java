package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Drawing;
import com.djohannes.ac.za.domain.Evaluation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrawingFactoryTest {

    @Test
    public void getDrawing()
    {
        Evaluation evaluation = EvaluationFactory.getEvaluation(5);
        Drawing drawing = DrawingFactory.getDrawing("circle",evaluation);
        Assert.assertNotNull(drawing.getId());
        Assert.assertEquals(5, evaluation.getRating());
        Assert.assertEquals("circle", drawing.getShapes());
    }
}