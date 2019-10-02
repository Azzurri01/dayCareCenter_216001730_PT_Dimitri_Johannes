package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.drawing.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrawingRepository extends JpaRepository<Drawing, String>
{

}