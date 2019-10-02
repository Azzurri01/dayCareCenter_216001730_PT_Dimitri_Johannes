package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.teacher.Teacher;
import java.util.List;

public interface TeacherService extends IService<Teacher, String> {

    List<Teacher> getAll();
}
