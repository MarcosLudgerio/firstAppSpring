package br.ufpb.dcx.firstApp.firstAppSpring.dto;

import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;

public class DisciplinaIdNomeLikesDTO {

    private Long id;
    private String nome;
    private int likes;

    public DisciplinaIdNomeLikesDTO() {}

    public DisciplinaIdNomeLikesDTO(Disciplina disciplina) {
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.likes = disciplina.getLikes();
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "DisciplinaIdNomeLikesDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", likes=" + likes +
                '}';
    }
}
