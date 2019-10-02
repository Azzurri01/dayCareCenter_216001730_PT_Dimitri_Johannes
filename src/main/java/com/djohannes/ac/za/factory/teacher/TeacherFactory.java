package com.djohannes.ac.za.factory.teacher;

import com.djohannes.ac.za.domain.teacher.Teacher;
import com.djohannes.ac.za.util.Misc;

public class TeacherFactory
{
    public static Teacher getTeacher(String fName, String lName, String gender, String dob, int age)
    {
        return new Teacher.Builder()
                .id(Misc.generateId())
                .firstName(fName)
                .lastName(lName)
                .gender(gender)
                .dateOfBirth(dob)
                .age(age)
                .build();
    }
}
