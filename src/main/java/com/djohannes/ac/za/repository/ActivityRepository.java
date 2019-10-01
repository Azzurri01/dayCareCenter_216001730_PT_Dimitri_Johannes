package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String>
{
    //Set<Activity> getAll();
}
