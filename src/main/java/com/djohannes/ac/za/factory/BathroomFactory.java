package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Bathroom;

public class BathroomFactory
{
    public static Bathroom getBathroomBreak(String time)
    {
        return new Bathroom.Builder()
                .getBathroomBreak(time)
                .build();
    }
}
