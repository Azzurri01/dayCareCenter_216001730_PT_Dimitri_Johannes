package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Parent;

public class ParentFactory
{
    public static Parent getParent(String name, String surname, String phone)
    {
        return new Parent.Builder()
                .getName(name)
                .getSurname(surname)
                .getPhone(phone)
                .build();
    }
}
