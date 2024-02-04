package com.beerRevolution.helpdeskback.models;

import com.beerRevolution.helpdeskback.enuns.Perfil;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Pessoa {

    //protected class a classe herdeira tem acesso a essas variaveis
    protected Integer id;
    protected String nome;

    protected  String cpf;

    protected String email;

    protected String senha;


    protected Set<Integer> perfils = new HashSet<>();

    protected LocalDate dataCriacao = LocalDate.now();


    // equals and hash code para id e cpf apenas

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(email, pessoa.email) && Objects.equals(senha, pessoa.senha) && Objects.equals(perfils, pessoa.perfils) && Objects.equals(dataCriacao, pessoa.dataCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, email, senha, perfils, dataCriacao);
    }

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
        return perfils.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
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




    //SET<ARRAY OBJETO> NAO PERMITE QUE TENHA 2 VALORES IGUAIS NESSE ARRAY



    // construtor da super classe sem parametros
    public Pessoa(){
        super();

        //toda pessoa criada pelo menos vai ter o enum PERFIL DE CLIENTE
        // SE NAO TIVER NENHUM PARAMETRO PELO MENOS O PERFIL DE CLIENTE ELE VAI TER INCIALMENTE
        //VAI SER ADD AUTOMATICAMENTE NO CONSTRUTOR NO ENUM DE PERFIL DES CLIENTE

        addPerfils(Perfil.CLIENTE);
    }

        // construtor com parametros sem ser super sem localDate e setPerfil
        // que nao vao ser criados na hora da construcao do objeto
    public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;

        //O PERFIL DE CLIENTE ELE VAI TER INCIALMENTE
        //VAI SER ADD AUTOMATICAMENTE NO CONSTRUTOR NO ENUM DE PERFIL DES CLIENTE , ALEM DOS PARAMETROS
        addPerfils(Perfil.CLIENTE);
    }
}
