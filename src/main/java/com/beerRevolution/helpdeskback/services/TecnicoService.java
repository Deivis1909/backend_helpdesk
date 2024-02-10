package com.beerRevolution.helpdeskback.services;

import com.beerRevolution.helpdeskback.dtos.TecnicoDto;
import com.beerRevolution.helpdeskback.models.Tecnico;
import com.beerRevolution.helpdeskback.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> optional = tecnicoRepository.findById(id);

        //  returna optional se objeto tecnico nao vim , retorna um nullo
        return optional.orElse(null);
    }
    public Tecnico salvar(TecnicoDto tecnicoDto){

        Tecnico tecnico = new Tecnico(tecnicoDto);

        // objeto de retorno retorno assincrono
        return tecnicoRepository.save(tecnico);


    }
}
