package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Name;

import java.util.Set;

public interface NameService extends IService<Name, String> {

    Set<Name> getAll();
}
