package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Suburb;
import com.djohannes.ac.za.util.Misc;

public class SuburbFactory
{
    public static Suburb getSuburb(String areaCode, Name name, Population population)
    {
        return new Suburb.Builder()
                .id(Misc.generateId())
                .code(areaCode)
                .name(name)
                .population(population)
                .build();
    }
}
