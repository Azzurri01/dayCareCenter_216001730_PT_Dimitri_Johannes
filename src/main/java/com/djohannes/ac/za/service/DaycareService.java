package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Daycare;

import java.util.Set;

public interface DaycareService extends IService<Daycare, String> {

    Set<Daycare> getAll();
}