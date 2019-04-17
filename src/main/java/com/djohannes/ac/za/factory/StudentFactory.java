package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Student;

public class StudentFactory {
    public static Student getStudent(int id) {
        return new Student.Builder()
                .getID(id)
                .build();
    }
}

