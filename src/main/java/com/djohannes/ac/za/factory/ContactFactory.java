package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Contact;

public class ContactFactory
{
    public static Contact getContact(String telefone, String email)
    {
        return new Contact.Builder()
                .contactNo(telefone)
                .email(email)
                .build();
    }
}
