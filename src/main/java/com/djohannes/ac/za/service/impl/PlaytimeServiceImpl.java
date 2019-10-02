package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Playtime;
import com.djohannes.ac.za.repository.PlaytimeRepository;
import com.djohannes.ac.za.service.PlaytimeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PlaytimeServiceImpl")
public class PlaytimeServiceImpl implements PlaytimeService {

    @Autowired
    private PlaytimeRepository repository;

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