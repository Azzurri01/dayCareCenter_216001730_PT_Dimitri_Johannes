package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Allergy;
import com.djohannes.ac.za.util.Misc;

public class AllergyFactory
{
    public static Allergy getAllergy(String name, String code)
    {
        return new Allergy.Builder()
                .getName(name)
                .getCode(code)
                .build();
    }
}
