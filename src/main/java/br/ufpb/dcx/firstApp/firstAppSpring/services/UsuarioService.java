package br.ufpb.dcx.firstApp.firstAppSpring.services;

import br.ufpb.dcx.firstApp.firstAppSpring.model.Usuario;
import br.ufpb.dcx.firstApp.firstAppSpring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usarioRepository;

    public Usuario insertNewUsuario(Usuario usuario){
        this.usarioRepository.save(usuario);
        return usuario;
    }
}
