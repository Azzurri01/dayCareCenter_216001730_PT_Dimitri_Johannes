package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Address;
import com.djohannes.ac.za.repository.AddressRepository;
import com.djohannes.ac.za.repository.impl.AddressRepositoryImpl;
import com.djohannes.ac.za.service.LocationService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private static LocationServiceImpl service = null;
    private AddressRepository repository;

    private LocationServiceImpl() {
        this.repository = AddressRepositoryImpl.getRepository();
    }

    public static LocationServiceImpl getService(){
        if (service == null) service = new LocationServiceImpl();
        return service;
    }

    @Override
    public Address create(Address address) {
        return this.repository.create(address);
    }

    @Override
    public Address update(Address address) {
        return this.repository.update(address);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Address read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Address> getAll() {
        return this.repository.getAll();
    }
}