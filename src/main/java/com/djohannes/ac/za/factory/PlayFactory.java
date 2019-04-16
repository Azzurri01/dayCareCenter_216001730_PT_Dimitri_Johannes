package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Play;

public class PlayFactory
{
    public static Play getPlayTime(String time)
    {
        return new Play.Builder()
                .getPlayTime(time)
                .build();
    }
}
