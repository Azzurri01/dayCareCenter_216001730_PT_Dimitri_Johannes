package com.djohannes.ac.za.factory;
import  com.djohannes.ac.za.domain.Teacher;

public class TeacherFactory 
{
    public static Teacher getTeacher(String title, String name, String surname, int empNum)
    {
        return new Teacher.Builder()
            .getTitle(title)
                .getName(name)
                .getSurname(surname)
                .getEmpNum(empNum)
                .build();
    }
}
