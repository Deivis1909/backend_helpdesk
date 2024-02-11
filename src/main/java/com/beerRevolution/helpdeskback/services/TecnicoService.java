package com.beerRevolution.helpdeskback.services;

import com.beerRevolution.helpdeskback.dtos.TecnicoDto;
import com.beerRevolution.helpdeskback.exceptions.ObjectNotFoundException;
import com.beerRevolution.helpdeskback.models.Pessoa;
import com.beerRevolution.helpdeskback.models.Tecnico;
import com.beerRevolution.helpdeskback.repositories.PessoaRepository;
import com.beerRevolution.helpdeskback.repositories.TecnicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> optional = tecnicoRepository.findById(id);

        //  returna optional se objeto tecnico nao vim , retorna um nullo
        return optional.orElseThrow(()-> new ObjectNotFoundException("deu merda , objeto nao encontrado id: "+id));
    }

    @Transactional
    public Tecnico salvar(TecnicoDto tecnicoDto){



        Tecnico tecnico = new Tecnico(tecnicoDto);

        // objeto de retorno retorno assincrono
        return tecnicoRepository.save(tecnico);


    }

    // validacao pelo cpf e email
    //verifica se email ou cpf existe no banco


    public List<Tecnico> findAll(){

        return tecnicoRepository.findAll();

    }
    public Tecnico update(Integer id,TecnicoDto tecnicodto){
        tecnicodto.setId(id);
        Tecnico tecnico = findById(id);
        tecnico = new Tecnico(tecnicodto);
        return tecnicoRepository.save(tecnico);
    }
}
