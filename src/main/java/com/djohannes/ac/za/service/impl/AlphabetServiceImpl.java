package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Alphabet;
import com.djohannes.ac.za.repository.AlphabetRepository;
import com.djohannes.ac.za.service.AlphabetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AlphabetServiceImpl")
public class AlphabetServiceImpl implements AlphabetService {

    @Autowired
    private AlphabetRepository repository;

    @Override
    public Alphabet create(Alphabet alphabet) {
        return this.repository.save(alphabet);
    }

    @Override
    public Alphabet update(Alphabet alphabet) {
        return this.repository.save(alphabet);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Alphabet read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Alphabet> getAll() {
        return this.repository.findAll();
    }
}