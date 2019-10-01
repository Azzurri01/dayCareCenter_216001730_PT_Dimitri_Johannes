package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Classroom;

import java.util.List;
import java.util.Set;

public interface ClassroomService extends IService<Classroom, String> {

    List<Classroom> getAll();
}
