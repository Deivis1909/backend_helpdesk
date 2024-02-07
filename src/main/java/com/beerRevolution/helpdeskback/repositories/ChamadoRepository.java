package com.beerRevolution.helpdeskback.repositories;

import com.beerRevolution.helpdeskback.models.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado,Integer> {
}
