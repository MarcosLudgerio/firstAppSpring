package br.ufpb.dcx.firstApp.firstAppSpring.services;

import br.ufpb.dcx.firstApp.firstAppSpring.exceptions.DisciplinaNotFoundException;
import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;
import br.ufpb.dcx.firstApp.firstAppSpring.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public Disciplina insertNewDiscplina(Disciplina disciplina){
        this.disciplinaRepository.save(disciplina);
        Disciplina disciplina1 = (Disciplina) this.disciplinaRepository.findById(Long.valueOf(this.disciplinaRepository.count())).get();
        return disciplina1;
    }

    public List<Disciplina> getAll(){
        return this.disciplinaRepository.findAll();
    }

    public List<Disciplina> getHanking(){
        List<Disciplina> listDisciplinaOrd = this.getAll();
        listDisciplinaOrd.sort((o1, o2) -> o1.getNota() > o2.getNota() ? -1 : 1);
        return listDisciplinaOrd;
    }

    public Disciplina getOne(Long id) throws DisciplinaNotFoundException {
        Optional<Disciplina> disciplina = this.disciplinaRepository.findById(id);
        if(disciplina != null)
            return disciplina.get();
        throw new DisciplinaNotFoundException("Disciplina não encontrada");
    }

    public Disciplina updateNota(double newNota, Long id) throws DisciplinaNotFoundException {
        Disciplina disciplina = this.getOne(id);
        disciplina.setNota(newNota);
        return disciplina;
    }

    public Disciplina updateNome(String newNome, Long id) throws DisciplinaNotFoundException {
        Disciplina disciplina = this.getOne(id);
        disciplina.setNome(newNome);
        return disciplina;
    }

    public Disciplina delete(Long id) throws DisciplinaNotFoundException{
        Disciplina disciplina = this.getOne(id);
        this.disciplinaRepository.delete(disciplina);
        return disciplina;
    }

}
