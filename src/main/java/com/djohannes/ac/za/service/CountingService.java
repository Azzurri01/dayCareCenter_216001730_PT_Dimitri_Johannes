package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Counting;

import java.util.List;
import java.util.Set;

public interface CountingService extends IService<Counting, String> {

    List<Counting> getAll();
}
