package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.City;

import java.util.List;
import java.util.Set;

public interface CityService extends IService<City, String> {

    List<City> getAll();
}
