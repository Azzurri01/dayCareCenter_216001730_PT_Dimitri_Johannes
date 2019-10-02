package com.djohannes.ac.za.factory.playtime;

import com.djohannes.ac.za.domain.playtime.Playtime;
import com.djohannes.ac.za.util.Misc;

public class PlaytimeFactory
{
    public static Playtime getPlaytime(String behaviour)
    {
        return new Playtime.Builder()
                .id(Misc.generateId())
                .social(behaviour)
                .build();
    }
}

