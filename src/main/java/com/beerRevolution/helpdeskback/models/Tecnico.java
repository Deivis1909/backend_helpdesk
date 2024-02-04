package com.beerRevolution.helpdeskback.models;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa{
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
        super();
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha, List<Chamado> chamados) {
        super(id, nome, cpf, email, senha);
        this.chamados = chamados;
    }

    //getter
    public List<Chamado> getChamados() {
        return chamados;
    }

    //setter
    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
