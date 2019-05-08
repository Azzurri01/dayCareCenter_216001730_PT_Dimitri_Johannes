package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Counting;

import java.util.Set;

public interface CountingService extends IService<Counting, String> {

    Set<Counting> getAll();
}
