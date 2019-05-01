package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Address;
import com.djohannes.ac.za.repository.AddressRepository;

import java.util.HashSet;
import java.util.Set;

public class AddressRepositoryImpl implements AddressRepository {

    private static AddressRepositoryImpl repository = null;
    private Set<Address> addresses;

    private AddressRepositoryImpl() {
        this.addresses = new HashSet<>();
    }

    private Address findAddress(String addressId) {
        /*return this.addresses.stream()
                .filter(address -> address.getNo().trim().equals(addressId))
                .findAny()
                .orElse(null);*/
        return null;
    }

    public static AddressRepositoryImpl getRepository(){
        if(repository == null) repository = new AddressRepositoryImpl();
        return repository;
    }

    public Address create(Address address){
        this.addresses.add(address);
        return address;
    }

    public Address read(final String addressId){
        //find the student in the set and return it if it exist
        Address address = findAddress(addressId);
        return address;
    }

    public Address update(Address address) {
        // find the student, update it and return the updated student
        Address toDelete = findAddress(address.getNo());
        if(toDelete != null) {
            this.addresses.remove(toDelete);
            return create(address);
        }
        return null;
    }

    public void delete(String addressId) {
        //find the student and delete it if it exists
        Address address = findAddress(addressId);
        if (address != null) this.addresses.remove(address);
    }

    public Set<Address> getAll(){
        return this.addresses;
    }
}
