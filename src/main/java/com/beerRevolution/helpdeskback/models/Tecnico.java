package com.beerRevolution.helpdeskback.models;

import com.beerRevolution.helpdeskback.enuns.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Pessoa{
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "tecnico") // 1 tecnico pode ter muitas chamadas
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {

        super();
        // todos vai receber um perfil de cliente de inicio
        addPerfils(Perfil.CLIENTE);
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha, List<Chamado> chamados) {
        super(id, nome, cpf, email, senha);
        this.chamados = chamados;

        // todos vai receber um perfil de cliente de inicio
        addPerfils(Perfil.CLIENTE);
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
