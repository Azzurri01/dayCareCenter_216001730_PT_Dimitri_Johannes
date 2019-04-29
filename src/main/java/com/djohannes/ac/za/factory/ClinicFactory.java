package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Clinic;

public class ClinicFactory
{
    public static Clinic getClinic(String id, String name)
    {
        return new Clinic.Builder()
                .getID(id)
                .getName(name)
                .build();
    }
}
