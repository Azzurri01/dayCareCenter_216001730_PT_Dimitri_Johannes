package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Province;
import com.djohannes.ac.za.repository.ProvinceRepository;
//import com.djohannes.ac.za.repository.impl.ProvinceRepositoryImpl;
import com.djohannes.ac.za.service.ProvinceService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ProvinceServiceImpl")
public class ProvinceServiceImpl implements ProvinceService {

    private static ProvinceServiceImpl service = null;

    @Autowired
    //@Qualifier("ProvinceMemory")
    private ProvinceRepository repository;

    public static ProvinceServiceImpl getService(){
        if (service == null) service = new ProvinceServiceImpl();
        return service;
    }

    @Override
    public Province create(Province province) {
        return this.repository.save(province);
    }

    @Override
    public Province update(Province province) {
        return this.repository.save(province);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Province read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Province> getAll() {
        return this.repository.findAll();
    }
}