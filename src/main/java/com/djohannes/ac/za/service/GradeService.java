package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Grade;

import java.util.List;
import java.util.Set;

public interface GradeService extends IService<Grade, String> {

    List<Grade> getAll();
}
