package com.beerRevolution.helpdeskback.controllers;

import com.beerRevolution.helpdeskback.dtos.ChamadoDto;
import com.beerRevolution.helpdeskback.models.Chamado;
import com.beerRevolution.helpdeskback.services.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoDto> findbyId(@PathVariable Integer id){
        Chamado chamado = chamadoService.findById(id);
        return ResponseEntity.ok().body(new ChamadoDto(chamado));

    }
    @PostMapping
    public ResponseEntity<ChamadoDto> salvar(@Valid @RequestBody ChamadoDto chamadodto){
        Chamado chamado = chamadoService.salvar(chamadodto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(chamado.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }

    @GetMapping
    public ResponseEntity <List<ChamadoDto>> findAll(){
        List<Chamado> chamados = chamadoService.findAll();

        // transforma a lista de chamados em uma LISTA DE CHAMADOS DTO PARA RETORNAR
        // USA UM MAP PARA ISSO
        // colect -> coleta itens internos
        List<ChamadoDto> chamadoDtos = chamados.stream().map(obj->new ChamadoDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(chamadoDtos);


    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoDto> update(@PathVariable Integer id,@RequestBody ChamadoDto chamadoDto){
        Chamado chamado = chamadoService.update(id,chamadoDto);
        return ResponseEntity.ok().body(new ChamadoDto(chamado));

    }


}
