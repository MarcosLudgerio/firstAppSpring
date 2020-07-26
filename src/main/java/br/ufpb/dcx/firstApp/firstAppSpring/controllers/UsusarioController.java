package br.ufpb.dcx.firstApp.firstAppSpring.controllers;

import br.ufpb.dcx.firstApp.firstAppSpring.model.Usuario;
import br.ufpb.dcx.firstApp.firstAppSpring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UsusarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/usuarios")
    public ResponseEntity<Usuario> insertNewUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(this.usuarioService.insertNewUsuario(usuario), HttpStatus.CREATED);
    }


}
