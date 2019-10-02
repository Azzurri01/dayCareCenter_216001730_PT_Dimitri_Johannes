package com.djohannes.ac.za.factory.student;

import com.djohannes.ac.za.domain.student.Student;
import com.djohannes.ac.za.util.Misc;

public class StudentFactory
{
    public static Student getStudent(String fName, String lName, String gender, String dob, int age)
    {
        return new Student.Builder()
                .id(Misc.generateId())
                .firstName(fName)
                .lastName(lName)
                .gender(gender)
                .dateOfBirth(dob)
                .age(age)
                .build();
    }
}

