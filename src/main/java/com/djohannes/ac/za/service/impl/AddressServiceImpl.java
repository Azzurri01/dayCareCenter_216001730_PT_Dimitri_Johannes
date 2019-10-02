package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.address.Address;
import com.djohannes.ac.za.repository.AddressRepository;
import com.djohannes.ac.za.service.AddressService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

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
