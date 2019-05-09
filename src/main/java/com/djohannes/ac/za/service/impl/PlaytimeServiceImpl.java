package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Playtime;
import com.djohannes.ac.za.repository.PlaytimeRepository;
import com.djohannes.ac.za.repository.impl.PlaytimeRepositoryImpl;
import com.djohannes.ac.za.service.PlaytimeService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class PlaytimeServiceImpl implements PlaytimeService {

    private static PlaytimeServiceImpl service = null;
    private PlaytimeRepository repository;

    private PlaytimeServiceImpl() {
        this.repository = PlaytimeRepositoryImpl.getRepository();
    }

    public static PlaytimeServiceImpl getService(){
        if (service == null) service = new PlaytimeServiceImpl();
        return service;
    }

    @Override
    public Playtime create(Playtime playtime) {
        return this.repository.create(playtime);
    }

    @Override
    public Playtime update(Playtime playtime) {
        return this.repository.update(playtime);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Playtime read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Playtime> getAll() {
        return this.repository.getAll();
    }
}