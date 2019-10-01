package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Counting;
import com.djohannes.ac.za.domain.Evaluation;
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
