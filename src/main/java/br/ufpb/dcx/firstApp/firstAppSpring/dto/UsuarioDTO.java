package br.ufpb.dcx.firstApp.firstAppSpring.dto;

import br.ufpb.dcx.firstApp.firstAppSpring.model.Usuario;

public class UsuarioDTO {
    private String email;
    private String senha;

    public UsuarioDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public UsuarioDTO(Usuario usuario) {
        this(usuario.getEmail(), usuario.getSenha());
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
