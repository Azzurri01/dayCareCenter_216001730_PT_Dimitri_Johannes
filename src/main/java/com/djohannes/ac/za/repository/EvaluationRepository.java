package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.evaluation.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, String>
{

}

