package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Playtime;
import com.djohannes.ac.za.domain.Evaluation;

public class PlaytimeFactory
{
    public static Playtime getPlaytime(String behaviour, Evaluation evaluation)
    {
        return new Playtime.Builder()
                .social(behaviour)
                .evaluation(evaluation)
                .build();
    }
}
