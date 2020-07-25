package br.ufpb.dcx.firstApp.firstAppSpring.controllers;

import br.ufpb.dcx.firstApp.firstAppSpring.dto.DisciplinaIdNomeNotaDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.dto.DisciplinaIdNomeCommentsDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.dto.DisciplinaIdNomeDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.dto.DisciplinaIdNomeLikesDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.exceptions.DisciplinaNotFoundException;
import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;
import br.ufpb.dcx.firstApp.firstAppSpring.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DisciplinaController {

    @Autowired
    DisciplinaService objDisciplinaService;

    @PostMapping(value = "/api/disciplinas")
    public ResponseEntity<Disciplina> insert(@RequestBody DisciplinaIdNomeNotaDTO disciplinaIdNomeNotaDTO){
        return new ResponseEntity<>(objDisciplinaService.insertNewDiscplina(DisciplinaIdNomeNotaDTO.fromDTO(disciplinaIdNomeNotaDTO)), HttpStatus.OK);
    }

    @GetMapping(value = "/api/disciplinas")
    public ResponseEntity<List<DisciplinaIdNomeDTO>> findAll(){
        return new ResponseEntity<>(objDisciplinaService.getAll().stream().map(obj -> new DisciplinaIdNomeDTO(obj)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> find(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.objDisciplinaService.getOne(id), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/api/disciplinas/nome/{id}")
    public ResponseEntity<Disciplina> updateNomeDisciplina(@RequestBody String nome, @PathVariable Long id){
        try {
            return new ResponseEntity<>(this.objDisciplinaService.updateNome(nome, id), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/api/disciplinas/nota/{id}")
    public ResponseEntity<DisciplinaIdNomeNotaDTO> updateNotaDisciplina(@RequestBody DisciplinaIdNomeNotaDTO disciplinaIdNomeNotaDTO, @PathVariable Long id){
        try {
            Disciplina disciplina = this.objDisciplinaService.updateNota(disciplinaIdNomeNotaDTO.getNota(), id);
            return new ResponseEntity<>(new DisciplinaIdNomeNotaDTO(disciplina), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new DisciplinaIdNomeNotaDTO(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/api/disciplinas/likes/{id}")
    public ResponseEntity<DisciplinaIdNomeLikesDTO> receivedLike(@PathVariable Long id){
        try {
            Disciplina disciplina = this.objDisciplinaService.receivedLike(id);
            DisciplinaIdNomeLikesDTO obj = new DisciplinaIdNomeLikesDTO(disciplina);
            System.out.println("==================");
            System.out.println(obj);
            System.out.println("==================");
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new DisciplinaIdNomeLikesDTO(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/api/disciplinas/comentarios/{id}")
    public ResponseEntity<DisciplinaIdNomeCommentsDTO> receivedComment(@RequestBody DisciplinaIdNomeCommentsDTO disciplinaDTO, @PathVariable Long id){
        try {
            Disciplina disciplina = this.objDisciplinaService.receivedComment(id, disciplinaDTO.getComments());
            return new ResponseEntity<>(new DisciplinaIdNomeCommentsDTO(disciplina), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new DisciplinaIdNomeCommentsDTO(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/rancking/likes",method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<List<?>> ranckingByLikes(){
        List<Disciplina> disciplinas = this.objDisciplinaService.getRankingByLikes();
        return new ResponseEntity<>(disciplinas.stream().map(obj -> new DisciplinaIdNomeLikesDTO(obj)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(value = "/rancking/notas",method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<List<?>> ranckingByNotas(){
        List<Disciplina> disciplinas = this.objDisciplinaService.getRankingByNotas();
        return new ResponseEntity<>(disciplinas.stream().map(obj -> new DisciplinaIdNomeNotaDTO(obj)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> delete(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.objDisciplinaService.delete(id), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }
}
