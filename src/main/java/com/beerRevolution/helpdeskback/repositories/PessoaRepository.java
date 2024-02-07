package com.beerRevolution.helpdeskback.repositories;

import com.beerRevolution.helpdeskback.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
