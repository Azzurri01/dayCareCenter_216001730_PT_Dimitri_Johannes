package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Alphabet;
import com.djohannes.ac.za.repository.AlphabetRepository;
import com.djohannes.ac.za.repository.impl.AlphabetRepositoryImpl;
import com.djohannes.ac.za.service.AlphabetService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class AlphabetServiceImpl implements AlphabetService {

    private static AlphabetServiceImpl service = null;
    private AlphabetRepository repository;

    private AlphabetServiceImpl() {
        this.repository = AlphabetRepositoryImpl.getRepository();
    }

    public static AlphabetServiceImpl getService(){
        if (service == null) service = new AlphabetServiceImpl();
        return service;
    }

    @Override
    public Alphabet create(Alphabet alphabet) {
        return this.repository.create(alphabet);
    }

    @Override
    public Alphabet update(Alphabet alphabet) {
        return this.repository.update(alphabet);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Alphabet read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Alphabet> getAll() {
        return this.repository.getAll();
    }
}