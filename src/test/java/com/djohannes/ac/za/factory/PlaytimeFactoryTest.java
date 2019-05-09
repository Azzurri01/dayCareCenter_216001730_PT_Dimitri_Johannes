package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Playtime;
import com.djohannes.ac.za.domain.Evaluation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaytimeFactoryTest {

    @Test
    public void getPlaytime()
    {
        Evaluation evaluation = EvaluationFactory.getEvaluation(5);
        Playtime playtime = PlaytimeFactory.getPlaytime("social",evaluation);
        Assert.assertEquals(evaluation.getRating(), playtime.getEvaluation().getRating());
        Assert.assertEquals("social", playtime.getBehaviour());
    }
}