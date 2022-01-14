package br.ufpb.dcx.firstApp.firstAppSpring.services;

import br.ufpb.dcx.firstApp.firstAppSpring.dto.UsuarioDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.exceptions.UsuarioNotFoundException;
import br.ufpb.dcx.firstApp.firstAppSpring.model.Usuario;
import br.ufpb.dcx.firstApp.firstAppSpring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    JWTService jwtService;

    @PostConstruct
    private void initUsuarios() {
            List<Usuario> usuarios = new ArrayList<>();
            Usuario u1 = new Usuario("usuario1", "usuario1", "usuario1");
            Usuario u2 = new Usuario("usuario2", "usuario2", "usuario2");
            Usuario u3 = new Usuario("usuario3", "usuario3", "usuario3");
            usuarios.add(u1);
            usuarios.add(u2);
            usuarios.add(u3);
            this.usuarioRepository.saveAll(usuarios);
    }

    public Usuario insertNewUsuario(Usuario usuario){
        this.usuarioRepository.save(usuario);
        return usuario;
    }

    public List<Usuario> getAll(){
        return this.usuarioRepository.findAll();
    }

    public Usuario getOne(String email) throws UsuarioNotFoundException {
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(email);
        return usuario.orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado"));
    }

    public Usuario updateEmailUsuario(String email, String token) throws UsuarioNotFoundException{
        Optional<String> emailUsuarioLogado = jwtService.getEmailUsuarioLogado(token);
        if(!emailUsuarioLogado.isPresent()) throw new UsuarioNotFoundException("Ocorreu um erro na autenticação, por favor verifique os campos e tente novamente");
        Usuario usuario1 = this.getOne(email);
        usuario1.setEmail(usuario1.getEmail());
        usuario1.setNome(usuario1.getNome());
        usuario1.setSenha(usuario1.getSenha());
        return this.insertNewUsuario(usuario1);
    }

    public UsuarioDTO deleteUsuario(String headerAuthotization) throws UsuarioNotFoundException{
        Optional<String> usuarioId = jwtService.getEmailUsuarioLogado(headerAuthotization);
        Usuario usuario = this.validateUsuario(usuarioId);
        this.usuarioRepository.delete(usuario);
        return new UsuarioDTO(usuario);
    }

    private Usuario validateUsuario(Optional<String> id) throws UsuarioNotFoundException{
        if(!id.isPresent())
            throw new UsuarioNotFoundException("Usuário não encontrado");
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(id.get());
        if(!usuario.isPresent())
            throw new UsuarioNotFoundException("E-mail não encontrado!");
        return usuario.get();
    }

    public Object updateUsuario(String id, Usuario usuario) throws UsuarioNotFoundException {
        Optional<Usuario> usuario1 = usuarioRepository.findById(id);
        if(!usuario1.isPresent()) throw new UsuarioNotFoundException("Usuário não encontrado");
        usuario1.get().setEmail(usuario.getEmail());
        usuario1.get().setNome(usuario.getNome());
        usuario1.get().setSenha(usuario.getSenha());
        return usuarioRepository.save(usuario1);
    }
}
