package br.ufpb.dcx.firstApp.firstAppSpring.controllers;

import br.ufpb.dcx.firstApp.firstAppSpring.exceptions.DisciplinaNotFoundException;
import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;
import br.ufpb.dcx.firstApp.firstAppSpring.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/disciplinas")
public class DisciplinaController {
    @Autowired
    DisciplinaService objDisciplinaService;


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public Disciplina insert(@RequestBody Disciplina disciplina){
        return objDisciplinaService.insertNewDiscplina(disciplina);
    }
}
