package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Daycare;
import com.djohannes.ac.za.repository.DaycareRepository;
import com.djohannes.ac.za.service.DaycareService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DaycareServiceImpl")
public class DaycareServiceImpl implements DaycareService {

    @Autowired
    private DaycareRepository repository;

    @Override
    public Daycare create(Daycare daycare) {
        return this.repository.save(daycare);
    }

    @Override
    public Daycare update(Daycare daycare) {
        return this.repository.save(daycare);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Daycare read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Daycare> getAll() {
        return this.repository.findAll();
    }
}