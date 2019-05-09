package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Province;

import java.util.Set;

public interface ProvinceService extends IService<Province, String> {

    Set<Province> getAll();
}
