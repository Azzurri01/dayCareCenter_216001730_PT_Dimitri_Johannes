package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Allergy;
import com.djohannes.ac.za.repository.AllergyRepository;
import com.djohannes.ac.za.repository.impl.AllergyRepositoryImpl;
import com.djohannes.ac.za.service.AllergyService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class AllergyServiceImpl implements AllergyService {

    private static AllergyServiceImpl service = null;
    private AllergyRepository repository;

    private AllergyServiceImpl() {
        this.repository = AllergyRepositoryImpl.getRepository();
    }

    public static AllergyServiceImpl getService(){
        if (service == null) service = new AllergyServiceImpl();
        return service;
    }

    @Override
    public Allergy create(Allergy allergy) {
        return this.repository.create(allergy);
    }

    @Override
    public Allergy update(Allergy allergy) {
        return this.repository.update(allergy);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Allergy read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Allergy> getAll() {
        return this.repository.getAll();
    }
}