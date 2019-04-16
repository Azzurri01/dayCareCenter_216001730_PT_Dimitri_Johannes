package com.djohannes.ac.za.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.Payment;

public class PaymentFactoryTest {

    @Test
    public void getType()
    {
        Payment payment = PaymentFactory.getType("Cash");
        Assert.assertEquals("Cash", payment.getType());
    }
}