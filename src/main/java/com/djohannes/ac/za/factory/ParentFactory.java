package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Parent;
import com.djohannes.ac.za.util.Misc;

public class ParentFactory
{
    public static Parent getParent(Name name, Contact contact)
    {
        return new Parent.Builder()
                .id(Misc.generateId())
                .name(name)
                .Contact(contact)
                .build();
    }
}
