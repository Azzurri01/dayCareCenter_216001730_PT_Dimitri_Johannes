package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Province;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Population;

public class ProvinceFactory
{
    public static Province getProvince(String id, Name name, Population population)
    {
        return new Province.Builder()
                .id(id)
                .name(name)
                .population(population)
                .build();
    }
}
