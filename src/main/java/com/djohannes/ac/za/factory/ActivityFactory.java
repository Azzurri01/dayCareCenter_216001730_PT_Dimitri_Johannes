package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Activity;
import com.djohannes.ac.za.util.Misc;

public class ActivityFactory
{
    public static Activity getActivity(String id, String name)
    {
        return new Activity.Builder()
                .getID(Misc.generateId())
                .getName(name)
                .build();
    }
}
