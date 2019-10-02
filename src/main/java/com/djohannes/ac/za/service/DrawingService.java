package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.drawing.Drawing;
import java.util.List;

public interface DrawingService extends IService<Drawing, String>
{
    List<Drawing> getAll();
}