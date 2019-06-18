package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.util.Misc;

public class ContactFactory
{
    public static Contact getContact(String tel, String email)
    {
        return new Contact.Builder()
                .id(Misc.generateId())
                .contactNo(tel)
                .email(email)
                .build();
    }
}
