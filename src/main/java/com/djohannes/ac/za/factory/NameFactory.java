package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Name;

public class NameFactory
{
    public static Name getName(String name, String surname)
    {
        return new Name.Builder()
                .name(name)
                .surname(surname)
                .build();
    }

    public static Name getName(String name)
    {
        return new Name.Builder()
                .orgName(name)
                .build();
    }
}
