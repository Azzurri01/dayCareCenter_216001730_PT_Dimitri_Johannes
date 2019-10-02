package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.playtime.Playtime;
import java.util.List;

public interface PlaytimeService extends IService<Playtime, String> {

    List<Playtime> getAll();
}

