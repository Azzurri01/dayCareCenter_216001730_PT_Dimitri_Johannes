package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.repository.NameRepository;
import com.djohannes.ac.za.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("NameServiceImpl")
public class NameServiceImpl implements NameService {

    @Autowired
    private NameRepository repository;

    @Override
    public Name create(Name name) {
        return this.repository.save(name);
    }

    @Override
    public Name update(Name name) {
        return this.repository.save(name);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Name read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Name> getAll() {
        return this.repository.findAll();
    }
}