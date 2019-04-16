package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Learning;

public class LearningFactory
{
    public static Learning getLearning(String type, int student)
    {
        return new Learning.Builder()
                .getType(type)
                .getStudent(student)
                .build();
    }
}
