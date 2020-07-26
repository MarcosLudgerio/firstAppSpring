package br.ufpb.dcx.firstApp.firstAppSpring.services;

import br.ufpb.dcx.firstApp.firstAppSpring.dto.UsuarioDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.exceptions.UsuarioNotFoundException;
import br.ufpb.dcx.firstApp.firstAppSpring.model.Usuario;
import br.ufpb.dcx.firstApp.firstAppSpring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usarioRepository;

    @Autowired
    JWTService jwtService;

    public Usuario insertNewUsuario(Usuario usuario){
        this.usarioRepository.save(usuario);
        return usuario;
    }

    public List<Usuario> getAll(){
        return this.usarioRepository.findAll();
    }

    public Usuario getOne(String email) throws UsuarioNotFoundException {
        Optional<Usuario> usuario = this.usarioRepository.findByEmail(email);
        return usuario.orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado"));
    }

    public Usuario updateUsuario(String email, Usuario usuario) throws UsuarioNotFoundException{
        Usuario usuario1 = this.getOne(email);
        usuario1.setEmail(usuario.getEmail());
        usuario1.setNome(usuario.getNome());
        usuario1.setSenha(usuario.getSenha());
        return this.insertNewUsuario(usuario1);
    }

    public UsuarioDTO deleteUsuario(String headerAuthotization) throws UsuarioNotFoundException{
        Optional<String> usuarioId = jwtService.getUsuario(headerAuthotization);
        Usuario usuario = this.validateUsuariio(usuarioId);
        this.usarioRepository.delete(usuario);
        return new UsuarioDTO(usuario);
    }

    private Usuario validateUsuariio(Optional<String> id) throws UsuarioNotFoundException{
        if(!id.isPresent())
            throw new UsuarioNotFoundException("Usuário não encontrado");
        Optional<Usuario> usuario = this.usarioRepository.findByEmail(id.get());
        if(!usuario.isPresent())
            throw new UsuarioNotFoundException("E-mail não encontrado!");
        return usuario.get();
    }

}
