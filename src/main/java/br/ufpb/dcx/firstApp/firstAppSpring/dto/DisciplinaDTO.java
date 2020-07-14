package br.ufpb.dcx.firstApp.firstAppSpring.dto;

import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;

import java.io.Serializable;


public class DisciplinaDTO implements Serializable {
    private Long id;
    private String nome;
    private Double nota;

    public DisciplinaDTO() {}

    public DisciplinaDTO(Disciplina disciplina) {
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.nota = disciplina.getNota();
    }

    public static Disciplina fromDTO(DisciplinaDTO disciplinaDTO){
        return new Disciplina(disciplinaDTO.getNome(), disciplinaDTO.getNota());
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
