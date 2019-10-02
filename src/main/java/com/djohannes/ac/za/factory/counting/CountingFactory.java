package com.djohannes.ac.za.factory.counting;

import com.djohannes.ac.za.domain.counting.Counting;
import com.djohannes.ac.za.util.Misc;

public class CountingFactory
{
    public static Counting getCounting(int number)
    {
        return new Counting.Builder()
                .id(Misc.generateId())
                .number(number)
                .build();
    }
}

