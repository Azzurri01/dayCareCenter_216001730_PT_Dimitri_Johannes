package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Classroom;

public class ClassroomFactory
{
    public static Classroom getClassroom(int roomNo)
    {
        return new Classroom.Builder()
                .getRoom(roomNo)
                .build();
    }
}
