package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Province;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.util.Misc;

public class ProvinceFactory
{
    public static Province getProvince(Name name, Population population)
    {
        return new Province.Builder()
                .id(Misc.generateId())
                .name(name)
                .population(population)
                .build();
    }
}
