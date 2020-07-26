package br.ufpb.dcx.firstApp.firstAppSpring.services;

import br.ufpb.dcx.firstApp.firstAppSpring.dto.UsuarioDTO;
import br.ufpb.dcx.firstApp.firstAppSpring.filters.TokenFilter;
import br.ufpb.dcx.firstApp.firstAppSpring.model.Usuario;
import br.ufpb.dcx.firstApp.firstAppSpring.repositories.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JWTService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public LoginResponse autentication(UsuarioDTO usuarioDTO) {
        String errorMessage = "Login failed, please try again";
        Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
        if (usuario.isPresent() && usuarioDTO.getSenha().equals(usuario.get().getSenha()))
            return new LoginResponse(this.generateToken(usuarioDTO));
        return new LoginResponse(errorMessage);
    }

    private String generateToken(UsuarioDTO usuarioDTO) {
        String token = Jwts.builder().setSubject(usuarioDTO.getEmail()).signWith(SignatureAlgorithm.HS512, NADA_IMPORTANT).setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000)).compact();
        return token;
    }

    public static final String NADA_IMPORTANT = "issonaoimporta";

    public Optional<String> getUsuario(String headerAuthorization) {
        if (headerAuthorization == null || !headerAuthorization.startsWith("Bearer ")) throw new SecurityException();
        String token = headerAuthorization.substring(TokenFilter.TOKEN_INDEX);
        String subject = "";
        try {
            subject = Jwts.parser().setSigningKey(this.NADA_IMPORTANT).parseClaimsJws(token).getBody().getSubject();
        } catch (SignatureException ex) {
            throw new SecurityException("Token invalid");
        }

        return Optional.of(subject);
    }


}
