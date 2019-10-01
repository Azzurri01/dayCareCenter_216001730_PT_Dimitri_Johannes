package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Drawing;
import com.djohannes.ac.za.repository.DrawingRepository;
//import com.djohannes.ac.za.repository.impl.DrawingRepositoryImpl;
import com.djohannes.ac.za.service.DrawingService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("DrawingServiceImpl")
public class DrawingServiceImpl implements DrawingService {

    private static DrawingServiceImpl service = null;

    @Autowired
    //@Qualifier("DrawingMemory")
    private DrawingRepository repository;

    public static DrawingServiceImpl getService(){
        if (service == null) service = new DrawingServiceImpl();
        return service;
    }

    @Override
    public Drawing create(Drawing drawing) {
        return this.repository.save(drawing);
    }

    @Override
    public Drawing update(Drawing drawing) {
        return this.repository.save(drawing);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Drawing read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Drawing> getAll() {
        return this.repository.findAll();
    }
}