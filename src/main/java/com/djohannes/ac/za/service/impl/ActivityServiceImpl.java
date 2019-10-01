package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Activity;
import com.djohannes.ac.za.repository.ActivityRepository;
//import com.djohannes.ac.za.repository.impl.ActivityRepositoryImpl;
import com.djohannes.ac.za.service.ActivityService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ActivityServiceImpl")
public class ActivityServiceImpl implements ActivityService {

    private static ActivityServiceImpl service = null;

    @Autowired
    //@Qualifier("ActivityMemory")
    private ActivityRepository repository;

    public static ActivityServiceImpl getService(){
        if (service == null) service = new ActivityServiceImpl();
        return service;
    }

    @Override
    public Activity create(Activity activity) {
        return this.repository.save(activity);
    }

    @Override
    public Activity update(Activity activity) {
        return this.repository.save(activity);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Activity read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Activity> getAll() {
        return this.repository.findAll();
    }
}