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


}
