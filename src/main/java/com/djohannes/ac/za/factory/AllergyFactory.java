package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Allergy;

public class AllergyFactory
{
    public static Allergy getAllergy(String allergy)
    {
        return new Allergy.Builder()
                .getAllergy(allergy)
                .build();
    }
}
