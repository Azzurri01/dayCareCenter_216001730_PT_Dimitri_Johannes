package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Playtime;

import java.util.Set;

public interface PlaytimeService extends IService<Playtime, String> {

    Set<Playtime> getAll();
}
