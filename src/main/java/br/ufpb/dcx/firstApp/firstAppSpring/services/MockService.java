package br.ufpb.dcx.firstApp.firstAppSpring.services;

import br.ufpb.dcx.firstApp.firstAppSpring.exceptions.DisciplinaNotFoundException;
import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;


import java.util.ArrayList;
import java.util.List;

public class MockService {
    List<Disciplina> disciplinas;

    public MockService() {
        this.disciplinas = new ArrayList<>();
    }

    public Disciplina insert(Disciplina disciplina){
        disciplina.setId(disciplinas.size() + 1);
        this.disciplinas.add(disciplina);
        return disciplina;
    }

    public List<Disciplina> getAll(){
        return this.disciplinas;
    }

    public Disciplina getOne(int id) throws DisciplinaNotFoundException {
        Disciplina disciplina1 = null;
        for(Disciplina d : this.disciplinas)
            if(d.getId() == id)
                disciplina1 = d;
        if(disciplina1 != null)
            return disciplina1;
       throw new DisciplinaNotFoundException("Nenhuma disciplina encontrada!");
    }

    public Disciplina updateDisciplina(Disciplina disciplina) throws DisciplinaNotFoundException{
        Disciplina disciplinaAlterar = this.getOne(disciplina.getId());
        disciplinaAlterar.setNome(disciplina.getNome());
        disciplinaAlterar.setNota(disciplina.getNota());
        return disciplinaAlterar;
    }

    public void deleteDisciplina(int id){
        Disciplina disciplina1 = null;
        for(Disciplina d : this.disciplinas) if(d.getId() == id) disciplina1 = d;
        this.disciplinas.remove(disciplina1);
    }

    public Disciplina updateNotaDisciplina(double newNota, Long id){
        Disciplina disciplina1 = null;
        for(Disciplina d : this.disciplinas) if(d.getId() == id) disciplina1 = d;
        disciplina1.setNota(newNota);
       return disciplina1;
    }

    public Disciplina updateNomeDisciplina(String newNome, Long id){
        Disciplina disciplina1 = null;
        for(Disciplina d : this.disciplinas) if(d.getId() == id) disciplina1 = d;
        disciplina1.setNome(newNome);
        return disciplina1;
    }

}
