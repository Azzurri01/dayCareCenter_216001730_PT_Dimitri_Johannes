package com.djohannes.ac.za.factory.parent;

import com.djohannes.ac.za.domain.parent.Parent;
import com.djohannes.ac.za.util.Misc;

public class ParentFactory
{
    public static Parent getParent(String fName, String lName, String gender, String dob, int age)
    {
        return new Parent.Builder()
                .id(Misc.generateId())
                .firstName(fName)
                .lastName(lName)
                .gender(gender)
                .dateOfBirth(dob)
                .age(age)
                .build();
    }
}

