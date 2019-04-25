package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Student1;

public class StudentFactory1 {
    public static Student1 getStudent(int id) {
        return new Student1.Builder()
                .getID(id)
                .build();
    }
}

