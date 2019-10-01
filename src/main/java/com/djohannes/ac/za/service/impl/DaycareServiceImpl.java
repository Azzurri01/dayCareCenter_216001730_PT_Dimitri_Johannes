package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Daycare;
import com.djohannes.ac.za.repository.DaycareRepository;
//import com.djohannes.ac.za.repository.impl.DaycareRepositoryImpl;
import com.djohannes.ac.za.service.DaycareService;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service("DaycareServiceImpl")
public class DaycareServiceImpl implements DaycareService {

    private static DaycareServiceImpl service = null;
    private DaycareRepository repository;

    public static DaycareServiceImpl getService(){
        if (service == null) service = new DaycareServiceImpl();
        return service;
    }

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