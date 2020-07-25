package br.ufpb.dcx.firstApp.firstAppSpring.services;

import br.ufpb.dcx.firstApp.firstAppSpring.dto.DisciplinaIdNomeDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.dto.DisciplinaIdNomeLikesDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.exceptions.DisciplinaNotFoundException;
import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;
import br.ufpb.dcx.firstApp.firstAppSpring.repositories.DisciplinaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @PostConstruct
    public void initDisciplinas() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>() {
        };
        InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/Disciplinas.json");
        try {
            List<Disciplina> disciplinas = objectMapper.readValue(inputStream, typeReference);
            this.disciplinaRepository.saveAll(disciplinas);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public Disciplina insertNewDiscplina(Disciplina disciplina) {
        this.disciplinaRepository.save(disciplina);
        Disciplina disciplina1 = (Disciplina) this.disciplinaRepository.findById(Long.valueOf(this.disciplinaRepository.count())).get();
        return disciplina1;
    }

    public List<Disciplina> getAll() {
        List<Disciplina> disciplinaList = this.disciplinaRepository.findAll();
        List<DisciplinaIdNomeDTO> disciplinaDTOList = disciplinaList.stream().map(obj -> new DisciplinaIdNomeDTO(obj)).collect(Collectors.toList());
        return disciplinaList;
    }

    public List<Disciplina> getRankingByNotas() {
        List<Disciplina> disciplinaList = this.disciplinaRepository.findAll();
        disciplinaList.sort((o1, o2) -> o1.getNota() > o2.getNota() ? -1 : 1);
        return disciplinaList;
    }

    public List<Disciplina> getRankingByLikes() {
        List<Disciplina> disciplinaList = this.disciplinaRepository.findAll();
        disciplinaList.sort((o1, o2) -> o1.getLikes() > o2.getLikes() ? -1 : 1);
        List<DisciplinaIdNomeLikesDTO> disciplinaDTOList = disciplinaList.stream().map(obj -> new DisciplinaIdNomeLikesDTO(obj)).collect(Collectors.toList());
        return disciplinaList;
    }

    public Disciplina getOne(Long id) throws DisciplinaNotFoundException {
        Optional<Disciplina> disciplina = this.disciplinaRepository.findById(id);
        if (disciplina != null)
            return disciplina.get();
        throw new DisciplinaNotFoundException("Disciplina não encontrada");
    }

    public Disciplina updateNota(double newNota, Long id) throws DisciplinaNotFoundException {
        Disciplina disciplina = this.getOne(id);
        if (disciplina.getNota() == 0) disciplina.setNota(newNota);
        else disciplina.setNota((newNota + disciplina.getNota()) / 2);
        return disciplina;
    }

    public Disciplina updateNome(String newNome, Long id) throws DisciplinaNotFoundException {
        Disciplina disciplina = this.getOne(id);
        disciplina.setNome(newNome);
        return disciplina;
    }

    public Disciplina delete(Long id) throws DisciplinaNotFoundException {
        Disciplina disciplina = this.getOne(id);
        this.disciplinaRepository.delete(disciplina);
        return disciplina;
    }

    public Disciplina receivedLike(Long id) throws DisciplinaNotFoundException {
        Disciplina disciplina = this.getOne(id);
        disciplina.setLikes(disciplina.getLikes() + 1);
        this.disciplinaRepository.save(disciplina);
        return disciplina;
    }

    public Disciplina receivedComment(Long id, String comment) throws DisciplinaNotFoundException {
        Disciplina disciplina = this.getOne(id);
        disciplina.setComment(comment);
        this.disciplinaRepository.save(disciplina);
        return disciplina;
    }

}
