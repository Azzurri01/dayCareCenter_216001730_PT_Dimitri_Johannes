package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Activity;
import com.djohannes.ac.za.repository.ActivityRepository;
import com.djohannes.ac.za.service.ActivityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ActivityServiceImpl")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository repository;

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