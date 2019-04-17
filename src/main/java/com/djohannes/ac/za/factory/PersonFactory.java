package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Person;

public class PersonFactory
{
    public static Person getPerson(String name, String surname, String phone, char gender, int age)
    {
        return new Person.Builder()
                .getName(name)
                .getSurname(surname)
                .getPhone(phone)
                .getGender(gender)
                .getAge(age)
                .build();
    }
}
