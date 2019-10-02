package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Province;
import com.djohannes.ac.za.repository.ProvinceRepository;
import com.djohannes.ac.za.service.ProvinceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProvinceServiceImpl")
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository repository;

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