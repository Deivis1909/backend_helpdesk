package com.beerRevolution.helpdeskback.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    // faz um relacionamento entre tabelas  , tras uma lista de Chamados pra Cliente
    private List<Chamado> chamados = new ArrayList<>();
    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);

    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
