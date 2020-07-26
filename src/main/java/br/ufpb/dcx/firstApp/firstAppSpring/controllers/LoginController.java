package br.ufpb.dcx.firstApp.firstAppSpring.controllers;

import br.ufpb.dcx.firstApp.firstAppSpring.dto.UsuarioDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.services.JWTService;
import br.ufpb.dcx.firstApp.firstAppSpring.services.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @Autowired
    private JWTService jwtService;

    @PostMapping(value = "/auth/login")
    public ResponseEntity<LoginResponse> authentication(@RequestBody UsuarioDTO usuarioDTO){
        return new ResponseEntity<>(jwtService.autentication(usuarioDTO), HttpStatus.OK);
    }

}
