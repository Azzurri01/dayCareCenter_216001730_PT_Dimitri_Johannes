package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Parent;

import java.util.Set;

public interface ParentService extends IService<Parent, String> {

    Set<Parent> getAll();
}
