package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Excursion;

public class ExcursionFactory
{
    public static Excursion getExcursion(String date, String venue)
    {
        return new Excursion.Builder()
                .getDate(date)
                .getVenue(venue)
                .build();
    }
}
