package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Teacher;

import java.util.List;
import java.util.Set;

public interface TeacherService extends IService<Teacher, String> {

    List<Teacher> getAll();
}
