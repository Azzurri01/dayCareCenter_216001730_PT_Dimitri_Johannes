package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Student;
import com.djohannes.ac.za.util.Misc;

public class StudentFactory {

    public static Student getStudent(String firstName, String lastName, int age) {
        return new Student.Builder().age(age)
                .studentFirstName(firstName)
                .studentLastName(lastName)
                .studentId(Misc.generateId())
                .build();
    }
}
