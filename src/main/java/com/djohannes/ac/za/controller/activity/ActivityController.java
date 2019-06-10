package com.djohannes.ac.za.controller.activity;


import com.djohannes.ac.za.domain.Activity;
import com.djohannes.ac.za.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    @Qualifier("ActivityServiceImpl")
    private ActivityService service;

    @PostMapping("/create")
    @ResponseBody
    public Activity create(Activity activity) {
        return service.create(activity);
    }

    @PostMapping("/update")
    @ResponseBody
    public Activity update(Activity activity) {
        return service.update(activity);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Activity read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Activity> getAll() {
        return service.getAll();
    }
}
