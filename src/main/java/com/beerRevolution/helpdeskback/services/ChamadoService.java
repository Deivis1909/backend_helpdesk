package com.beerRevolution.helpdeskback.services;

import com.beerRevolution.helpdeskback.dtos.ChamadoDto;
import com.beerRevolution.helpdeskback.enuns.Prioridade;
import com.beerRevolution.helpdeskback.enuns.Status;
import com.beerRevolution.helpdeskback.exceptions.ObjectNotFoundException;
import com.beerRevolution.helpdeskback.models.Chamado;
import com.beerRevolution.helpdeskback.models.Cliente;
import com.beerRevolution.helpdeskback.models.Tecnico;
import com.beerRevolution.helpdeskback.repositories.ChamadoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id){
        Optional<Chamado> chamadoOptional = chamadoRepository.findById(id);
        return chamadoOptional.orElseThrow(()-> new ObjectNotFoundException("objeto chamado nao encontrado -> id"+id));


    }

    @Transactional
    public Chamado salvar(ChamadoDto chamadoDto){
        //otica diferenete pra chamado
      //  return chamadoRepository.save( new Chamado(chamadoDto));
        return chamadoRepository.save(newChamado(chamadoDto));

    }

    //FAZENDO UM NOVO CHAMADO / ORDEM DE SERVIÇO
    // RECEBENDO CHAMADODTO COMO PARAMETRO
    // ADD CLIENTE E TECNICO AO CLIENTE
    private Chamado newChamado(ChamadoDto chamadoDto){
        Tecnico tecnico = tecnicoService.findById(chamadoDto.getTecnico());
        Cliente cliente = clienteService.findById(chamadoDto.getCliente());
        Chamado chamado = new Chamado();
        if(chamadoDto.getId() != null){
            chamado.setId(chamadoDto.getId());
        }
        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(chamadoDto.getPrioridade()));
        chamado.setStatus(Status.toEnum(chamadoDto.getStatus()));
        chamado.setTitulo(chamadoDto.getTitulo());
        chamado.setObservacoes(chamadoDto.getObservacoes());
        return chamado;
    }


}
