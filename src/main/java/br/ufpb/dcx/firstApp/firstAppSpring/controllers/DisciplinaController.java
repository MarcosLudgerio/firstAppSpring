package br.ufpb.dcx.firstApp.firstAppSpring.controllers;

import br.ufpb.dcx.firstApp.firstAppSpring.dto.DisciplinaDTO;
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


    @PutMapping(value = "/api/disciplinas/{id}/nome")
    public ResponseEntity<Disciplina> updateNomeDisciplina(@RequestBody String nome, @PathVariable Long id){ // LEMBRE QUE DESSA FORMA PODE NÃO DAR CERTO POR CONTA DESTAS LINHAS
        try {
            return new ResponseEntity<>(this.objDisciplinaService.updateNome(nome, id), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/api/disciplinas/{id}/nota")
    public ResponseEntity<Disciplina> updateNotaDisciplina(@RequestBody Double nota, @PathVariable Long id){ // LEMBRE QUE DESSA FORMA PODE NÃO DAR CERTO POR CONTA DESTAS LINHAS
        try {
            return new ResponseEntity<>(this.objDisciplinaService.updateNota(nota, id), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/api/disciplinas/likes/{id}")
    public ResponseEntity<DisciplinaDTO> receivedLike(@PathVariable Long id){ // LEMBRE QUE DESSA FORMA PODE NÃO DAR CERTO POR CONTA DESTAS LINHAS
        try {
            Disciplina disciplina = this.objDisciplinaService.receivedLike(id);
            return new ResponseEntity<>(new DisciplinaDTO(disciplina.getId(), disciplina.getNome(), disciplina.getLikes()), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new DisciplinaDTO(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> delete(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.objDisciplinaService.delete(id), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }



    @RequestMapping(value = "/rancking",method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<List<DisciplinaDTO>> rancking(){
        return new ResponseEntity<>(this.objDisciplinaService.getHanking(), HttpStatus.OK);
    }
}
