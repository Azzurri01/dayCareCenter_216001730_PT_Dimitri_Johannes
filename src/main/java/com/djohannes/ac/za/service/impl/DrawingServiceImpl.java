package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.drawing.Drawing;
import com.djohannes.ac.za.repository.DrawingRepository;
import com.djohannes.ac.za.service.DrawingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DrawingServiceImpl")
public class DrawingServiceImpl implements DrawingService {

    @Autowired
    private DrawingRepository repository;

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