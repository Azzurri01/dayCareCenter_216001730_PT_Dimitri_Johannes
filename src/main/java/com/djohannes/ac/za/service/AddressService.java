package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.address.Address;
import java.util.List;

public interface AddressService extends IService<Address, String> {

    List<Address> getAll();
}
