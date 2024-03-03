package com.beerRevolution.helpdeskback.controllers;

import com.beerRevolution.helpdeskback.dtos.TecnicoDto;
import com.beerRevolution.helpdeskback.models.Tecnico;
import com.beerRevolution.helpdeskback.services.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tecnicos")
@CrossOrigin("http://localhost:4200/")
public class TecnicoController {

    // injecao de dependencias do TecnicoService no tecnicoController ->
    // dai da pra usar todas as funcoes do tecnicoservice no tecnicocontroller
    @Autowired
    private TecnicoService tecnicoservice;


    //ResponseEntity é melhor para trabalhar pq da pra trabalhar
    // codigo de estatus , corpo da requicao , etc

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoDto> findById(@PathVariable Integer id){

       try {
           //  estancia do objeto tecnico recebe tecnico pego pelo id
           Tecnico tecnico = this.tecnicoservice.findById(id);

           // .OK.BODY(TECNICO) -> É O OBJETO DE RESPOSTA DO SERVIDOR
           return ResponseEntity.ok().body(new TecnicoDto(tecnico));
       } catch (Exception ex) {
           // Outras exceções genéricas
           return ResponseEntity.status(500).build();
       }
    }


    @GetMapping
    public ResponseEntity<List<TecnicoDto>> findAll(){
      List<Tecnico> tecnicos = tecnicoservice.findAll();
      List<TecnicoDto> tecnicoDtos = tecnicos.stream().map(obj->new TecnicoDto(obj)).collect(Collectors.toList());
      return ResponseEntity.ok().body(tecnicoDtos);

    }



    @PostMapping
    public ResponseEntity<Tecnico> salvar(@Valid @RequestBody TecnicoDto tecnicoDto){

        tecnicoDto.setId(null);
        Tecnico tecnico = tecnicoservice.salvar(tecnicoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(tecnico);





    }

    //@PostMapping
    //    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
    //        Usuario user = usuarioService.salvar(usuario);
    //        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    //    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoDto> update(@PathVariable Integer id,@Valid @RequestBody TecnicoDto tecnicoDto){
        Tecnico tecnico = tecnicoservice.update(id,tecnicoDto);
        return ResponseEntity.ok().body(new TecnicoDto(tecnico));


    }


    @DeleteMapping("{id}")
    public ResponseEntity<TecnicoDto> delete(@PathVariable  Integer id) throws Exception {
        tecnicoservice.delete(id);
        return ResponseEntity.noContent().build();


    }
}
