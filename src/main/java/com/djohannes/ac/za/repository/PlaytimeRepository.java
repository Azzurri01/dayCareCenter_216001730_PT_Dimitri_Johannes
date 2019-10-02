package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.playtime.Playtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaytimeRepository extends JpaRepository<Playtime, String>
{

}

