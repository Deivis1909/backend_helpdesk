package com.beerRevolution.helpdeskback.models;

import com.beerRevolution.helpdeskback.enuns.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa {

    private static final long serialVersionUID = 1L;

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

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
