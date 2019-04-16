package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Daycare;

public class DaycareFactory
{
    public static Daycare getDaycare(int id, String name)
    {
        return new Daycare.Builder()
                .getID(id)
                .getName(name)
                .build();
    }
}
