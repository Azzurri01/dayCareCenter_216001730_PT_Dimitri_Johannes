package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Daycare;

import java.util.List;
import java.util.Set;

public interface DaycareService extends IService<Daycare, String> {

    List<Daycare> getAll();
}