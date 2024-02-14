package com.beerRevolution.helpdeskback.services;


import com.beerRevolution.helpdeskback.dtos.ClienteDto;
import com.beerRevolution.helpdeskback.exceptions.ObjectNotFoundException;
import com.beerRevolution.helpdeskback.models.Cliente;
import com.beerRevolution.helpdeskback.models.Pessoa;
import com.beerRevolution.helpdeskback.models.Tecnico;
import com.beerRevolution.helpdeskback.repositories.ClienteRepository;
import com.beerRevolution.helpdeskback.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;


    public Cliente findById(Integer id){
        Optional<Cliente> optional = clienteRepository.findById(id);
        return optional.orElseThrow(()-> new ObjectNotFoundException("deu merda, game over"));

    }


    @Transactional
    public Cliente salvar(ClienteDto clienteDto){

        Cliente cliente = new Cliente(clienteDto);
        return clienteRepository.save(cliente);

    }


    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    //update
    @Transactional
    public Cliente update(Integer id, ClienteDto clienteDto){

        clienteDto.setId(id);
        Cliente cliente = findById(id);
        cliente = new Cliente(clienteDto);
        return clienteRepository.save(cliente);


    }
    @Transactional
    public void deletar(Integer id) throws Exception {
        Cliente cliente = findById(id);
        if(cliente.getChamados().size() > 0){
            throw new Exception("deu merda o cliente possui chamadas abertas");
        }

            clienteRepository.delete(cliente);
    }





}

