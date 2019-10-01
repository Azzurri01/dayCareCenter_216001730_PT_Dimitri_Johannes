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
       Playtime playtime = PlaytimeFactory.getPlaytime("social");
        Assert.assertEquals("social", playtime.getBehaviour());
    }
}