package com.beerRevolution.helpdeskback.controllers;

import com.beerRevolution.helpdeskback.dtos.ClienteDto;
import com.beerRevolution.helpdeskback.models.Cliente;
import com.beerRevolution.helpdeskback.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody ClienteDto clienteDto){
        clienteDto.setId(null);
        // objeto de cliente recebe o CLIENTEDTO DE TRANSPORTE
        Cliente cliente = clienteService.salvar(clienteDto);

        //URI -> URL DE ACESSO A ESSE NOVO OBJETO passndo id de tecnico como parametro
      //  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        //return ResponseEntity.created(uri).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);

    }



    @GetMapping
    public ResponseEntity<List<ClienteDto>>  findAll(){
        List<Cliente> cliente = clienteService.findAll();
        List<ClienteDto> clienteDtos = cliente.stream().map(obj->new ClienteDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(clienteDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Integer id){
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(new ClienteDto(cliente));

    }
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> update(@PathVariable Integer id,@Valid @RequestBody ClienteDto clienteDto){
        Cliente cliente = clienteService.update(id,clienteDto);
        return ResponseEntity.ok().body(new ClienteDto(cliente));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDto> deletar(@PathVariable Integer id) throws Exception {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
