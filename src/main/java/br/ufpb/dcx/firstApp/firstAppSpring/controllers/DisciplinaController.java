package br.ufpb.dcx.firstApp.firstAppSpring.controllers;

import br.ufpb.dcx.firstApp.firstAppSpring.exceptions.DisciplinaNotFoundException;
import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;
import br.ufpb.dcx.firstApp.firstAppSpring.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/disciplinas")
public class DisciplinaController {
    @Autowired
    DisciplinaService objDisciplinaService;


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Disciplina> insert(@RequestBody Disciplina disciplina){
        return ResponseEntity.ok().body(objDisciplinaService.insertNewDiscplina(disciplina));
    }

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<List<Disciplina>> findAll(){
        List<Disciplina> disciplinas = objDisciplinaService.getAll();
        return ResponseEntity.ok().body(disciplinas);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<Disciplina> find(@PathVariable int id){
        Disciplina disciplina = null;
        try {
            disciplina = this.objDisciplinaService.getOne(id);
        }catch (DisciplinaNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(disciplina);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Disciplina> update(@RequestBody Disciplina disciplina){
        try {
            disciplina = this.objDisciplinaService.update(disciplina);
        }catch (DisciplinaNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(disciplina);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public ResponseEntity<?> delete(@PathVariable int id){
        this.objDisciplinaService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
