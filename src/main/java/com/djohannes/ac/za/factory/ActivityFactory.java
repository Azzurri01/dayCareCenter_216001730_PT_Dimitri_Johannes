package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Activity;

public class ActivityFactory
{
    public static Activity getActivity(int id, String name)
    {
        return new Activity.Builder()
                .getID(id)
                .getName(name)
                .build();
    }
}
