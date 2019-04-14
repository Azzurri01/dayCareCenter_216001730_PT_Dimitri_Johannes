package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Student;

public class StudentFactory {
    public static Student getStudent(String firstName, String lastName, int age) {
        return new Student.Builder()
                .getName(firstName)
                .getSurname(lastName)
                .getAge(age)
                .build();
    }
}

