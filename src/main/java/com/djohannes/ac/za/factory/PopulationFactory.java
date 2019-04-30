package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Population;

public class PopulationFactory
{
    public static Population getTotal(int total)
    {
        return new Population.Builder()
                .population(total)
                .build();
    }
}
