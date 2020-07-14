package br.ufpb.dcx.firstApp.firstAppSpring.controllers;

import br.ufpb.dcx.firstApp.firstAppSpring.dto.DisciplinaDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.dto.DisciplinaIdNomeCommentsDTO;
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

@Controller
public class DisciplinaController {

    @Autowired
    DisciplinaService objDisciplinaService;

    @PostMapping(value = "/api/disciplinas")
    public ResponseEntity<Disciplina> insert(@RequestBody DisciplinaDTO disciplinaDTO){
        return new ResponseEntity<>(objDisciplinaService.insertNewDiscplina(disciplinaDTO), HttpStatus.OK);
    }


    @GetMapping(value = "/api/disciplinas")
    public ResponseEntity<List<DisciplinaDTO>> findAll(){
        return new ResponseEntity<>(objDisciplinaService.getAll(), HttpStatus.OK);
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
    public ResponseEntity<Disciplina> updateNomeDisciplina(@RequestBody String nome, @PathVariable Long id){ // LEMBRE QUE DESSA FORMA PODE NÃO DAR CERTO POR CONTA DESTAS LINHAS
        try {
            return new ResponseEntity<>(this.objDisciplinaService.updateNome(nome, id), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/api/disciplinas/nota/{id}")
    public ResponseEntity<DisciplinaDTO> updateNotaDisciplina(@RequestBody DisciplinaDTO disciplinaDTO, @PathVariable Long id){ // LEMBRE QUE DESSA FORMA PODE NÃO DAR CERTO POR CONTA DESTAS LINHAS
        try {
            Disciplina disciplina = this.objDisciplinaService.updateNota(disciplinaDTO.getNota(), id);
            return new ResponseEntity<>(new DisciplinaDTO(disciplina), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new DisciplinaDTO(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/api/disciplinas/likes/{id}")
    public ResponseEntity<DisciplinaIdNomeLikesDTO> receivedLike(@PathVariable Long id){ // LEMBRE QUE DESSA FORMA PODE NÃO DAR CERTO POR CONTA DESTAS LINHAS
        try {
            Disciplina disciplina = this.objDisciplinaService.receivedLike(id);
            return new ResponseEntity<>(new DisciplinaIdNomeLikesDTO(disciplina), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new DisciplinaIdNomeLikesDTO(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/api/disciplinas/comentarios/{id}")
    public ResponseEntity<DisciplinaIdNomeCommentsDTO> receivedComment(@RequestBody DisciplinaIdNomeCommentsDTO disciplinaDTO, @PathVariable Long id){ // LEMBRE QUE DESSA FORMA PODE NÃO DAR CERTO POR CONTA DESTAS LINHAS
        try {
            Disciplina disciplina = this.objDisciplinaService.receivedComment(id, disciplinaDTO.getComments());
            return new ResponseEntity<>(new DisciplinaIdNomeCommentsDTO(disciplina), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new DisciplinaIdNomeCommentsDTO(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/rancking/notas",method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<List<DisciplinaDTO>> ranckingByNotas(){
        return new ResponseEntity<>(this.objDisciplinaService.getHankingByNotas(), HttpStatus.OK);
    }

    @RequestMapping(value = "/rancking/likes",method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<List<DisciplinaIdNomeLikesDTO>> ranckingByLikes(){
        return new ResponseEntity<>(this.objDisciplinaService.getHankingByLikes(), HttpStatus.OK);
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
