package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Student;

import java.util.List;
import java.util.Set;

public interface StudentService extends IService<Student, String> {

    List<Student> getAll();
}
