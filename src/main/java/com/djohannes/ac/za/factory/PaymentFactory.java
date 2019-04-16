package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Payment;

public class PaymentFactory
{
    public static Payment getType(String type)
    {
        return new Payment.Builder()
                .getPaymentMethod(type)
                .build();
    }
}
