package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.util.Misc;

public class NameFactory
{
    public static Name getName(String name, String surname)
    {
        return new Name.Builder()
                .id(Misc.generateId())
                .name(name)
                .surname(surname)
                .build();
    }

    public static Name schoolName(String name)
    {
        return new Name.Builder()
                .orgName(name)
                .build();
    }
}
