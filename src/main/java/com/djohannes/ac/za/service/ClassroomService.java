package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.classroom.Classroom;
import java.util.List;

public interface ClassroomService extends IService<Classroom, String> {

    List<Classroom> getAll();
}

