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

    public List<Disciplina> getHanking(){
        List<Disciplina> listDisciplinaOrd = this.serviceDiscplinaMock.getAll();
        listDisciplinaOrd.sort((o1, o2) -> o1.getNota() > o2.getNota() ? -1 : 1);
        return listDisciplinaOrd;
    }

    public Disciplina getOne(int id) throws DisciplinaNotFoundException {
        return this.serviceDiscplinaMock.getOne(id);
    }

    public Disciplina updateNota(double newNota, Long id) throws DisciplinaNotFoundException {
        return this.serviceDiscplinaMock.updateNotaDisciplina(newNota, id);
    }

    public Disciplina updateNome(String newNome, Long id) throws DisciplinaNotFoundException {
        return this.serviceDiscplinaMock.updateNomeDisciplina(newNome, id);
    }

    public void delete(int id){
        this.serviceDiscplinaMock.deleteDisciplina(id);
    }

}
