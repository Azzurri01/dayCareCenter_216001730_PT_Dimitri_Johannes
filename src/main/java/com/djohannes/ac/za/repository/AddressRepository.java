package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String>
{

}

