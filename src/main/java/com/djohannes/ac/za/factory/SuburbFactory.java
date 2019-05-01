package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Suburb;

public class SuburbFactory
{
    public static Suburb getSuburb(String id, String areaCode, Name name, Population population)
    {
        return new Suburb.Builder()
                .id(id)
                .code(areaCode)
                .name(name)
                .population(population)
                .build();
    }
}
