package com.beerRevolution.helpdeskback.dtos;

import com.beerRevolution.helpdeskback.enuns.Perfil;
import com.beerRevolution.helpdeskback.models.Tecnico;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TecnicoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    protected String nome;

    protected String cpf;

    protected String email;

    protected String senha;

    protected Set<Integer> perfils = new HashSet<>();

    protected LocalDate dataCriacao = LocalDate.now();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public Set<Perfil> getPerfils() {

        // return de getPerfils com gambiarra pra pegar a descricao do ENUM E NAO O NUMERO DELE
        return perfils.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
        // faz um map de perfil e add em x ->

    }

    public void addPerfils(Perfil perfil) {
        this.perfils.add(perfil.getCodigo());
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }



    //construtor sem parametros
    public TecnicoDto() {
        super();
        addPerfils(Perfil.CLIENTE);
    }

    // construtor com parametros
    public TecnicoDto(Tecnico tecnico) {
        this.id = tecnico.getId();
        this.nome = tecnico.getNome();
        this.cpf = tecnico.getCpf();
        this.email = tecnico.getEmail();
        this.senha = tecnico.getSenha();
        this.perfils = tecnico.getPerfils().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = tecnico.getDataCriacao();
        addPerfils(Perfil.CLIENTE);
    }
}
