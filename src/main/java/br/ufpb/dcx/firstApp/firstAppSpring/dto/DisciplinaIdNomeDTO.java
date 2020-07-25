package br.ufpb.dcx.firstApp.firstAppSpring.dto;

import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;

public class DisciplinaIdNomeDTO {
    private Long id;
    private String nome;

    public DisciplinaIdNomeDTO(Disciplina disciplina) {
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
