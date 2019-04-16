package com.djohannes.ac.za.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.Cash;

public class CashFactoryTest {

    @Test
    public void getCash()
    {
        Cash cash = CashFactory.getCash(25);
        Assert.assertEquals(25, cash.getCash());
    }
}