package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.counting.Counting;
import java.util.List;

public interface CountingService extends IService<Counting, String> {

    List<Counting> getAll();
}
