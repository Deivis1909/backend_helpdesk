package com.beerRevolution.helpdeskback.controllers;

import com.beerRevolution.helpdeskback.dtos.TecnicoDto;
import com.beerRevolution.helpdeskback.models.Tecnico;
import com.beerRevolution.helpdeskback.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    // injecao de dependencias do TecnicoService no tecnicoController ->
    // dai da pra usar todas as funcoes do tecnicoservice no tecnicocontroller
    @Autowired
    private TecnicoService tecnicoservice;


    //ResponseEntity é melhor para trabalhar pq da pra trabalhar
    // codigo de estatus , corpo da requicao , etc

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoDto> findById(@PathVariable Integer id){


            //  estancia do objeto tecnico recebe tecnico pego pelo id
        Tecnico tecnico = this.tecnicoservice.findById(id);

        // .OK.BODY(TECNICO) -> É O OBJETO DE RESPOSTA DO SERVIDOR
        return ResponseEntity.ok().body(new TecnicoDto(tecnico));

    }

    @GetMapping
    public ResponseEntity<List<TecnicoDto>> findAll(){
      List<Tecnico> tecnicos = tecnicoservice.findAll();
      List<TecnicoDto> tecnicoDtos = tecnicos.stream().map(obj->new TecnicoDto(obj)).collect(Collectors.toList());
      return ResponseEntity.ok().body(tecnicoDtos);

    }



    @PostMapping
    public ResponseEntity<TecnicoDto> salvar(@RequestBody TecnicoDto tecnicoDto){

        tecnicoDto.setId(null);
        Tecnico tecnico = tecnicoservice.salvar(tecnicoDto);

        //URI -> URL DE ACESSO A ESSE NOVO OBJETO passndo id de tecnico como parametro
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId()).toUri();
        return ResponseEntity.created(uri).build();



    }
}
