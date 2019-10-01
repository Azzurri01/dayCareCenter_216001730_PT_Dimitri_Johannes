package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, String>
{
    //Set<Evaluation> getAll();
}