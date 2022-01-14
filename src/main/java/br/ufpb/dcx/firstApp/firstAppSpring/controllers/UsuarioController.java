package br.ufpb.dcx.firstApp.firstAppSpring.controllers;

import br.ufpb.dcx.firstApp.firstAppSpring.dto.UsuarioDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.exceptions.UsuarioNotFoundException;
import br.ufpb.dcx.firstApp.firstAppSpring.model.Usuario;
import br.ufpb.dcx.firstApp.firstAppSpring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/api/usuarios")
    public ResponseEntity<Usuario> insertNewUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(this.usuarioService.insertNewUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/usuarios")
    public ResponseEntity<List<Usuario>> findAllUsuarios(){
        return new ResponseEntity<>(this.usuarioService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/usuarios/{id}")
    public ResponseEntity<Usuario> findUsuario(@PathVariable String id) throws UsuarioNotFoundException {
        return new ResponseEntity<>(this.usuarioService.getOne(id), HttpStatus.OK);
    }

    @PutMapping(value = "/api/usuarios/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable String id, @RequestBody Usuario usuario) throws UsuarioNotFoundException{
        return new ResponseEntity<>(this.usuarioService.updateUsuario(id, usuario), HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/usuarios/{id}")
    public ResponseEntity<UsuarioDTO> deleteUsuario(@RequestHeader("Authorization") String token) throws UsuarioNotFoundException{
        return new ResponseEntity<>(this.usuarioService.deleteUsuario(token), HttpStatus.OK);
    }


}
