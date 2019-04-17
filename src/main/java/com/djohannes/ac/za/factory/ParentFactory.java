package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Parent;

public class ParentFactory
{
    public static Parent getParent(String employer)
    {
        return new Parent.Builder()
                .getEmployer(employer)
                .build();
    }
}
