package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Counting;
import com.djohannes.ac.za.domain.Evaluation;

public class CountingFactory
{
    public static Counting getCounting(int number, Evaluation evaluation)
    {
        return new Counting.Builder()
                .number(number)
                .evaluation(evaluation)
                .build();
    }
}
