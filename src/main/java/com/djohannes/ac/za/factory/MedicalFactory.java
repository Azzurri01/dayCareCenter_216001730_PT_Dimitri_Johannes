package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Medical;

public class MedicalFactory
{
    public static Medical getMedical(String allergy, String injection, String drop, String date, String deworm)
    {
        return new Medical.Builder()
                .getAllergy(allergy)
                .getInjection(injection)
                .getDrop(drop)
                .getDate(date)
                .getDeworm(deworm)
                .build();
    }
}
