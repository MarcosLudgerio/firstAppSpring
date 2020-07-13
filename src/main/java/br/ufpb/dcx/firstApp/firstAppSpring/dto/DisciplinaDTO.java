package br.ufpb.dcx.firstApp.firstAppSpring.dto;

import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;

import java.io.Serializable;


public class DisciplinaDTO implements Serializable {
    private Long id;
    private String nome;
    private Integer like;
    private Double nota;
    private String comment;

    public DisciplinaDTO() {}

    public DisciplinaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public DisciplinaDTO(Long id, String nome, Integer like) {
        this(id, nome);
        this.like = like;
    }

    public DisciplinaDTO(Long id, String nome, Double nota) {
        this(id, nome);
        this.nota = nota;
    }

    public DisciplinaDTO(Long id, String nome, String comment) {
        this(id, nome);
        this.comment = comment;
    }

    public static Disciplina fromDTO(DisciplinaDTO disciplinaDTO){
        return new Disciplina(disciplinaDTO.getNome(), disciplinaDTO.getNota());
    }

    public Integer getLike() {
        return like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
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
