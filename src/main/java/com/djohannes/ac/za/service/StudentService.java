package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.student.Student;
import java.util.List;

public interface StudentService extends IService<Student, String> {

    List<Student> getAll();
}
