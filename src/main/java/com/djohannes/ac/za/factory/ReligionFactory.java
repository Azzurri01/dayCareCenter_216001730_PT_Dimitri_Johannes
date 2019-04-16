package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Religion;

public class ReligionFactory
{
    public static Religion getReligion(String faith)
    {
        return new Religion.Builder()
                .getmeal(faith)
                .build();
    }
}
