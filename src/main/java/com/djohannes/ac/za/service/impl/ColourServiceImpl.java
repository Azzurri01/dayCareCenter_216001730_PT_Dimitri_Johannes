package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.colour.Colour;
import com.djohannes.ac.za.repository.ColourRepository;
import com.djohannes.ac.za.service.ColourService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ColourServiceImpl")
public class ColourServiceImpl implements ColourService {

    @Autowired
    private ColourRepository repository;

    @Override
    public Colour create(Colour colour) {
        return this.repository.save(colour);
    }

    @Override
    public Colour update(Colour colour) {
        return this.repository.save(colour);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Colour read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Colour> getAll() {
        return this.repository.findAll();
    }

}