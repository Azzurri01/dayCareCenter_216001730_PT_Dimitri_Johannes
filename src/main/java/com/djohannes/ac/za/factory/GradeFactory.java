package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Grade;

public class GradeFactory
{
    public static Grade getGrade(int grade)
    {
        return new Grade.Builder()
                .getGrade(grade)
                .build();
    }
}
