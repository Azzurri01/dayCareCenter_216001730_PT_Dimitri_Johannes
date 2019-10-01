package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Address;
import com.djohannes.ac.za.repository.AddressRepository;
//import com.djohannes.ac.za.repository.impl.AddressRepositoryImpl;
import com.djohannes.ac.za.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {

    private static AddressServiceImpl service = null;

    @Autowired
    //@Qualifier("AddressMemory")
    private AddressRepository repository;

    public static AddressServiceImpl getService(){
        if (service == null) service = new AddressServiceImpl();
        return service;
    }

    @Override
    public Address create(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Address update(Address address) {
        return this.repository.save(address);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Address read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Address> getAll() {
        return this.repository.findAll();
    }
}