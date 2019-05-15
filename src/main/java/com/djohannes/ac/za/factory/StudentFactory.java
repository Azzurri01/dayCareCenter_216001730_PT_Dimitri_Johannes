package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Student;
import com.djohannes.ac.za.domain.Address;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.domain.Parent;
import com.djohannes.ac.za.util.Misc;

public class StudentFactory {


    public static Student getStudent(Name name, Grade grade, String gender, int age, Address address, Parent parent) {
        return new Student.Builder()
                .id(Misc.generateId())
                .name(name)
                .grade(grade)
                .gender(gender)
                .age(age)
                .address(address)
                .parent(parent)
                .build();
    }
}
