package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Playtime;
import com.djohannes.ac.za.repository.PlaytimeRepository;
//import com.djohannes.ac.za.repository.impl.PlaytimeRepositoryImpl;
import com.djohannes.ac.za.service.PlaytimeService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("PlaytimeServiceImpl")
public class PlaytimeServiceImpl implements PlaytimeService {

    private static PlaytimeServiceImpl service = null;

    @Autowired
    //@Qualifier("PlaytimeMemory")
    private PlaytimeRepository repository;

    public static PlaytimeServiceImpl getService(){
        if (service == null) service = new PlaytimeServiceImpl();
        return service;
    }

    @Override
    public Playtime create(Playtime playtime) {
        return this.repository.save(playtime);
    }

    @Override
    public Playtime update(Playtime playtime) {
        return this.repository.save(playtime);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Playtime read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Playtime> getAll() {
        return this.repository.findAll();
    }
}