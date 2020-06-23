package br.ufpb.dcx.firstApp.firstAppSpring.services;

import br.ufpb.dcx.firstApp.firstAppSpring.exceptions.DisciplinaNotFoundException;
import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    MockService serviceDiscplinaMock = new MockService();

    public Disciplina insertNewDiscplina(Disciplina disciplina){
        Disciplina disciplina1 = this.serviceDiscplinaMock.insert(disciplina);
        return disciplina1;
    }

    public List<Disciplina> getAll(){
        return this.serviceDiscplinaMock.getAll();
    }

    public Disciplina getOne(int id) throws DisciplinaNotFoundException {
        return this.serviceDiscplinaMock.getOne(id);
    }

    public Disciplina update(Disciplina disciplina) throws DisciplinaNotFoundException {
        return this.serviceDiscplinaMock.updateDisciplina(disciplina);
    }

    public void delete(int id){
        this.serviceDiscplinaMock.deleteDisciplina(id);
    }

}
