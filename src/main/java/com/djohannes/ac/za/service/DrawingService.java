package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Drawing;

import java.util.List;
import java.util.Set;

public interface DrawingService extends IService<Drawing, String> {

    List<Drawing> getAll();
}
