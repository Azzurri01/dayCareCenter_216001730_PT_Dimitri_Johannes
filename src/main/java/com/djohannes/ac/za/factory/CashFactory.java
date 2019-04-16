package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Cash;

public class CashFactory
{
    public static Cash getCash(double amt)
    {
        return new Cash.Builder()
                .getCash(amt)
                .build();
    }
}
