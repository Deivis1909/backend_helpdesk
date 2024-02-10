package com.beerRevolution.helpdeskback.controllers;

import com.beerRevolution.helpdeskback.dtos.TecnicoDto;
import com.beerRevolution.helpdeskback.models.Tecnico;
import com.beerRevolution.helpdeskback.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
