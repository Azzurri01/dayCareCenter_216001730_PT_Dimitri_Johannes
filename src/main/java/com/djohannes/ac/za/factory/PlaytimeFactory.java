package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Playtime;
import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.util.Misc;

public class PlaytimeFactory
{
    public static Playtime getPlaytime(String behaviour, Evaluation evaluation)
    {
        return new Playtime.Builder()
                .id(Misc.generateId())
                .social(behaviour)
                .evaluation(evaluation)
                .build();
    }
}
