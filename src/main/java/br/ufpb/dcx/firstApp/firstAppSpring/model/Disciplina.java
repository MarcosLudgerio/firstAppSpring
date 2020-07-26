package br.ufpb.dcx.firstApp.firstAppSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Disciplina {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private Double nota;
    private int likes;

    private String comment;

    public Disciplina() {
    }

    public Disciplina(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public Disciplina(String nome, Double nota, int likes, String comment) {
        this(nome, nota);
        this.likes = likes;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", likes=" + likes +
                '}';
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
