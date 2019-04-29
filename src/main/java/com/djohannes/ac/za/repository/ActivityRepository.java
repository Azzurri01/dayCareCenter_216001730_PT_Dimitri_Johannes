package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Activity;

import java.util.Set;

public interface ActivityRepository extends IRepository<Activity, String>
{
    Set<Activity> getAll();
}
