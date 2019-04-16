package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Deworm;

public class DewormFactory
{
    public static Deworm getInjection(String injection)
    {
        return new Deworm.Builder()
                .getInjection(injection)
                .build();
    }
}
