package com.beerRevolution.helpdeskback.repositories;

import com.beerRevolution.helpdeskback.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
