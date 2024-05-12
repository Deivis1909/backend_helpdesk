package com.beerRevolution.helpdeskback.repositories;

import com.beerRevolution.helpdeskback.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    Optional<Pessoa> findByEmail(String email);





}
