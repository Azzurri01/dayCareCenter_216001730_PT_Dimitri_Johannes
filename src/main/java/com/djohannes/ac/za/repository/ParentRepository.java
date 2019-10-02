package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.parent.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, String>
{

}

