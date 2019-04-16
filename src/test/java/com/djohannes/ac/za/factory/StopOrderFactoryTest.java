package com.djohannes.ac.za.factory;

import javafx.scene.paint.Stop;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.StopOrder;

public class StopOrderFactoryTest {

    @Test
    public void getStopOrderDate()
    {
        StopOrder stopOrder = StopOrderFactory.getStopOrderDate("26");
        Assert.assertEquals("26", stopOrder.getDate());
    }
}