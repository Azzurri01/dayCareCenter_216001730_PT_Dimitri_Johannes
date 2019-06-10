package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Address;

import java.util.Set;

public interface AddressService extends IService<Address, String> {

    Set<Address> getAll();
}
