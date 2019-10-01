package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Colour;
import com.djohannes.ac.za.repository.ColourRepository;
//import com.djohannes.ac.za.repository.impl.ColourRepositoryImpl;
import com.djohannes.ac.za.service.ColourService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ColourServiceImpl")
public class ColourServiceImpl implements ColourService {

    private static ColourServiceImpl service = null;

    @Autowired
    //@Qualifier("ColourMemory")
    private ColourRepository repository;

    public static ColourServiceImpl getService(){
        if (service == null) service = new ColourServiceImpl();
        return service;
    }

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

    @Override
    public Colour retrieveByColour(String col) {
        List<Colour> colours = getAll();
        for(Colour colour : colours) {
            if (colour.getColour().equalsIgnoreCase(col))
                return colour;
        } return null;
    }
}