package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Counting;
import com.djohannes.ac.za.domain.Evaluation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountingFactoryTest {

    @Test
    public void getCounting()
    {
        Counting counting = CountingFactory.getCounting(5);
        Assert.assertEquals(5, counting.getNumber());
    }
}