package br.ufpb.dcx.firstApp.firstAppSpring.dto;

import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;

import java.io.Serializable;

public class DisciplinaDTO implements Serializable {
    private Long id;
    private String nome;
    private Integer like;

    public DisciplinaDTO() {
    }

    public DisciplinaDTO(Long id, String nome, Integer like) {
        this.id = id;
        this.nome = nome;
        this.like = like;
    }

    public DisciplinaDTO(Disciplina disciplina) {
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
    }

    public Disciplina fromDTO(){
        return new Disciplina(this.getNome());
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
