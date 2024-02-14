package com.beerRevolution.helpdeskback.dtos;

import com.beerRevolution.helpdeskback.enuns.Perfil;
import com.beerRevolution.helpdeskback.models.Cliente;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDto implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Integer id;

    @NotNull(message = "o campo nome é obrigatorio seu ganso")
    protected String nome;

    @NotNull(message="o campo cpf é obrigatorio")
    protected String cpf;

    @NotNull(message="o campo email é obrigatorio")
    protected String email;

    @NotNull(message="o campo senha é obrigatorio")
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

    public ClienteDto() {
        super();
        addPerfils(Perfil.CLIENTE);
    }

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
        this.perfils = cliente.getPerfils().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = cliente.getDataCriacao();
        addPerfils(Perfil.CLIENTE);
    }
}
