package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.allergy.Allergy;
import com.djohannes.ac.za.repository.AllergyRepository;
import com.djohannes.ac.za.service.AllergyService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AllergyServiceImpl")
public class AllergyServiceImpl implements AllergyService {

    @Autowired
    private AllergyRepository repository;

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
