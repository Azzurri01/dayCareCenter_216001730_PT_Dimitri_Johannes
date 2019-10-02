package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.grade.Grade;
import java.util.List;

public interface GradeService extends IService<Grade, String> {

    List<Grade> getAll();
}


