package br.ufpb.dcx.firstApp.firstAppSpring.services;

import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;

import java.util.List;

public class MockService {
    List<Disciplina> disciplinas;

    public Disciplina insert(Disciplina disciplina){
        disciplina.setId(disciplinas.size());
        this.disciplinas.add(disciplina);
        return disciplina;
    }
}
