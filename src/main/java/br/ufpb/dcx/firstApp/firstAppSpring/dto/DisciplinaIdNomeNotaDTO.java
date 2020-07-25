package br.ufpb.dcx.firstApp.firstAppSpring.dto;

import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;

import java.io.Serializable;

public class DisciplinaIdNomeNotaDTO implements Serializable {
    private Long id;
    private String nome;
    private Double nota;

    public DisciplinaIdNomeNotaDTO() {}

    public DisciplinaIdNomeNotaDTO(Disciplina disciplina) {
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.nota = disciplina.getNota();
    }

    public static Disciplina fromDTO(DisciplinaIdNomeNotaDTO disciplinaIdNomeNotaDTO){
        return new Disciplina(disciplinaIdNomeNotaDTO.getNome(), disciplinaIdNomeNotaDTO.getNota());
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


    @Override
    public String toString() {
        return "DisciplinaIdNomeNotaDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                '}';
    }
}
