package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Address;

import java.util.Set;

public interface AddressRepository extends IRepository<Address, String>
{
    Set<Address> getAll();
}
