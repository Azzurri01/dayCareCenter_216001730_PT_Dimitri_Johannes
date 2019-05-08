package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.util.Misc;

public class GradeFactory
{
    public static Grade getGrade(String grade)
    {
        return new Grade.Builder()
                .id(Misc.generateId())
                .getGrade(grade)
                .build();
    }
}
