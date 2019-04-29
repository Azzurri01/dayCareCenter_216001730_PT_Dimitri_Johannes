package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Name;
import  com.djohannes.ac.za.domain.Teacher;

public class TeacherFactory 
{
    public static Teacher getTeacher(String id, Name name, Contact contact)
    {
        return new Teacher.Builder()
                .id(id)
                .name(name)
                .contact(contact)
                .build();
    }
}
