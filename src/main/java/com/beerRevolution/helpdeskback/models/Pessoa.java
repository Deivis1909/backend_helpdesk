package com.beerRevolution.helpdeskback.models;

import com.beerRevolution.helpdeskback.enuns.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    //protected class a classe herdeira tem acesso a essas variaveis

    //@GeneratedValue(strategy = GenerationType.IDENTITY) o banco se responsabiliza por gerar o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nome;

    @Column(unique = true)
    protected  String cpf;

    @Column(unique = true)
    protected String email;

    protected String senha;


    //A anotação @ElementCollection em conjunto com os parâmetros fetch = FetchType.EAGER
    // é usada em um contexto de mapeamento de entidades no framework Spring com o Hibernate,
    // que é uma implementação de mapeamento objeto-relacional (ORM). E

    //A anotação @ElementCollection é usada para indicar que a coleção (perfils no seu exemplo)
    // é uma parte INTEGRANTE DA ENTIDADE PROPRIETARIA (a entidade que possui a coleção),
    // MAS NAO É UMA ENTIDADE POR SI SÓ. Ela é geralmente utilizada para representar coleções
    // de valores simples,
    // não-entidades, e é persistida em uma tabela separada pelo Hibernate.

    //O parâmetro fetch = FetchType.EAGER especifica que a coleção perfils deve ser
    // CARREGADA AUTOMATICAMENTE QUANDO A ENTIDADE PROPRIETARIA FOR CARREGADA.
    // Isso significa que o Hibernate tentará recuperar todos os elementos da coleção
    //
    // imediatamente, otimizando a consulta para incluir esses elementos.

    @ElementCollection(fetch = FetchType.EAGER)
    // cria uma tabela com name perfils
    @CollectionTable(name="perfils")
    protected Set<Integer> perfils = new HashSet<>();

    //pattern padrao
    @JsonFormat(pattern="dd/MM/yyyy")
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
