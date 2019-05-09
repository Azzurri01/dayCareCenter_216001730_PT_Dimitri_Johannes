package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Colour;
import com.djohannes.ac.za.repository.ColourRepository;
import com.djohannes.ac.za.repository.impl.ColourRepositoryImpl;
import com.djohannes.ac.za.service.ColourService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ColourServiceImpl implements ColourService {

    private static ColourServiceImpl service = null;
    private ColourRepository repository;

    private ColourServiceImpl() {
        this.repository = ColourRepositoryImpl.getRepository();
    }

    public static ColourServiceImpl getService(){
        if (service == null) service = new ColourServiceImpl();
        return service;
    }

    @Override
    public Colour create(Colour colour) {
        return this.repository.create(colour);
    }

    @Override
    public Colour update(Colour colour) {
        return this.repository.update(colour);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Colour read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Colour> getAll() {
        return this.repository.getAll();
    }
}