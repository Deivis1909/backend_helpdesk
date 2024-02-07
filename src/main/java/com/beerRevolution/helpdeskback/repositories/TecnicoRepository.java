package com.beerRevolution.helpdeskback.repositories;

import com.beerRevolution.helpdeskback.models.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {
}
