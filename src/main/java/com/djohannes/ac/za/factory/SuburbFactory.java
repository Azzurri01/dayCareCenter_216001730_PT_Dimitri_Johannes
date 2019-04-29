package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Suburb;

public class SuburbFactory
{
    public static Suburb getSuburb(String id, String name)
    {
        return new Suburb.Builder()
                .getID(id)
                .getName(name)
                .build();
    }
}
