package com.beerRevolution.helpdeskback.models;

import com.beerRevolution.helpdeskback.dtos.ClienteDto;
import com.beerRevolution.helpdeskback.dtos.TecnicoDto;
import com.beerRevolution.helpdeskback.enuns.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Cliente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    // faz um relacionamento entre tabelas  , tras uma lista de Chamados pra Cliente
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();
    public Cliente() {
        super();

        //sempre que um clente for criado , ja add um perfil pra ele
        addPerfils(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);

        //sempre que um clente for criado , ja add um perfil pra ele
        addPerfils(Perfil.CLIENTE);

    }
    public Cliente(ClienteDto obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.dataCriacao = obj.getDataCriacao();
        this.perfils = obj.getPerfils().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        addPerfils(Perfil.CLIENTE);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
