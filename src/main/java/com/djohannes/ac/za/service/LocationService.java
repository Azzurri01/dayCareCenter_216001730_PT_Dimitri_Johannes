package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Location;

import java.util.Set;

public interface LocationService extends IService<Location, String> {

    Set<Location> getAll();
}
