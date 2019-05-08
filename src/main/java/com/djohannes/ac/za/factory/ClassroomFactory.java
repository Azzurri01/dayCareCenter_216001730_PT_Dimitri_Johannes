package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Classroom;
import com.djohannes.ac.za.util.Misc;

public class ClassroomFactory
{
    public static Classroom getClassroom(String roomNo)
    {
        return new Classroom.Builder()
                .id(Misc.generateId())
                .room(roomNo)
                .build();
    }
}
