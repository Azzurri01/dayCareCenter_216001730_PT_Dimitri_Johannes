package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.util.Misc;

public class PopulationFactory
{
    public static Population getTotal(int total)
    {
        return new Population.Builder()
                .id(Misc.generateId())
                .population(total)
                .build();
    }
}
