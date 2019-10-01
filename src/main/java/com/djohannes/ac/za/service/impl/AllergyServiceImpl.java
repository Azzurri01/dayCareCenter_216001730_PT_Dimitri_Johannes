package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Allergy;
import com.djohannes.ac.za.repository.AllergyRepository;
//import com.djohannes.ac.za.repository.impl.AllergyRepositoryImpl;
import com.djohannes.ac.za.service.AllergyService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("AllergyServiceImpl")
public class AllergyServiceImpl implements AllergyService {

    private static AllergyServiceImpl service = null;

    @Autowired
    //@Qualifier("AllergyMemory")
    private AllergyRepository repository;

    public static AllergyServiceImpl getService(){
        if (service == null) service = new AllergyServiceImpl();
        return service;
    }

    @Override
    public Allergy create(Allergy allergy) {
        return this.repository.save(allergy);
    }

    @Override
    public Allergy update(Allergy allergy) {
        return this.repository.save(allergy);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Allergy read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Allergy> getAll() {
        return this.repository.findAll();
    }
}