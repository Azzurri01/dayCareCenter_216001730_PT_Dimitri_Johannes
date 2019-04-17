package com.djohannes.ac.za.factory;
import  com.djohannes.ac.za.domain.Teacher;

public class TeacherFactory 
{
    public static Teacher getTeacher(String qual)
    {
        return new Teacher.Builder()
                .getQual(qual)
                .build();
    }
}
