package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Student;
import com.djohannes.ac.za.util.Misc;

public class StudentFactory {
<<<<<<< HEAD

    public static Student getStudent(String firstName, String lastName, int age) {
        return new Student.Builder().age(age)
                .studentFirstName(firstName)
                .studentLastName(lastName)
                .studentId(Misc.generateId())
=======
    public static Student getStudent(int id) {
        return new Student.Builder()
                .getID(id)
>>>>>>> f36dbde0fbcd5e4d49bd3de4e3a5dd476a0f17cc
                .build();
    }
}
