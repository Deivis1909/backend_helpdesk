package com.beerRevolution.helpdeskback.models;

import com.beerRevolution.helpdeskback.enuns.Prioridade;
import com.beerRevolution.helpdeskback.enuns.Status;

import java.time.LocalDate;
import java.util.Objects;

public class Chamado {

    private Integer id;


    // now agora , pegadando a adata atual
    private LocalDate dataAbertura = LocalDate.now();

    private LocalDate dataFechamento ;

    private Prioridade prioridade;

    private Status status;

    private String titulo;

    private String observacoes;


    //relacacao entre tabelas com a tabela TECNICO
    private Tecnico tecnico;

    //RELACAO COM A TABELA CLIENTE
    private Cliente cliente;

    public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;

        //RELAÇÃO DE DEPENDENCIA ENTRE TABELAS
        // CLIENTE VAI TER TECNICO E CLIENTE
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public Chamado() {

        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chamado chamado = (Chamado) o;
        return Objects.equals(id, chamado.id) && Objects.equals(dataAbertura, chamado.dataAbertura) && Objects.equals(dataFechamento, chamado.dataFechamento) && prioridade == chamado.prioridade && status == chamado.status && Objects.equals(titulo, chamado.titulo) && Objects.equals(observacoes, chamado.observacoes) && Objects.equals(tecnico, chamado.tecnico) && Objects.equals(cliente, chamado.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataAbertura, dataFechamento, prioridade, status, titulo, observacoes, tecnico, cliente);
    }
}
