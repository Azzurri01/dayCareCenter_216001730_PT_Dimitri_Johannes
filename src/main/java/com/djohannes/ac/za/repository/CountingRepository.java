package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.counting.Counting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountingRepository extends JpaRepository<Counting, String>
{

}

