package br.ufpb.dcx.firstApp.firstAppSpring.controllers;

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

    @PostMapping(value = "/api/disciplinas/")
    public ResponseEntity<Disciplina> insert(@RequestBody Disciplina disciplina){
        return new ResponseEntity<>(objDisciplinaService.insertNewDiscplina(disciplina), HttpStatus.OK);
    }

    @GetMapping(value = "/api/disciplinas/")
    public ResponseEntity<List<Disciplina>> findAll(){
        return new ResponseEntity<>(objDisciplinaService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> find(@PathVariable int id){
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

    @PutMapping(value = "/api/disciplinas/{id}/nome")
    public ResponseEntity<Disciplina> updateNotaDisciplina(@RequestBody Double nota, @PathVariable Long id){ // LEMBRE QUE DESSA FORMA PODE NÃO DAR CERTO POR CONTA DESTAS LINHAS
        try {
            return new ResponseEntity<>(this.objDisciplinaService.updateNota(nota, id), HttpStatus.OK);
        }catch (DisciplinaNotFoundException ex){
            return new ResponseEntity<>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> delete(@PathVariable int id){
        return new ResponseEntity<>(this.objDisciplinaService.delete(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/rancking",method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<List<Disciplina>> rancking(){
        return new ResponseEntity<>(this.objDisciplinaService.getHanking(), HttpStatus.OK);
    }
}
