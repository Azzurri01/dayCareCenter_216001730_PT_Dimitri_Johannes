package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Name;
import  com.djohannes.ac.za.domain.Teacher;
import com.djohannes.ac.za.util.Misc;

public class TeacherFactory 
{
    public static Teacher getTeacher(Name name, Contact contact)
    {
        return new Teacher.Builder()
                .id(Misc.generateId())
                .name(name)
                .contact(contact)
                .build();
    }
}
