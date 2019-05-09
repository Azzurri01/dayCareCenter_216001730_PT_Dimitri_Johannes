package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Activity;

import java.util.Set;

public interface ActivityService extends IService<Activity, String> {

    Set<Activity> getAll();
}
