package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.counting.Counting;
import com.djohannes.ac.za.repository.CountingRepository;
import com.djohannes.ac.za.service.CountingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CountingServiceImpl")
public class CountingServiceImpl implements CountingService {

    @Autowired
    private CountingRepository repository;

    @Override
    public Counting create(Counting counting) {
        return this.repository.save(counting);
    }

    @Override
    public Counting update(Counting counting) {
        return this.repository.save(counting);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Counting read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Counting> getAll() {
        return this.repository.findAll();
    }
}
