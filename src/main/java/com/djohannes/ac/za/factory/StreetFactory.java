package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Street;

public class StreetFactory
{
    public static Street getStreet(String no, String name)
    {
        return new Street.Builder()
                .getID(no)
                .getName(name)
                .build();
    }
}
