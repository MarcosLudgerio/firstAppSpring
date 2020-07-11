package br.ufpb.dcx.firstApp.firstAppSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue
    Long id;
    String nome;
    Double nota;
    String comentarios;
    int likes;


    public Disciplina() {}

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public Disciplina(String nome, Double nota, int likes) {
        this.nome = nome;
        this.nota = nota;
        this.comentarios = comentarios;
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", comentarios='" + comentarios + '\'' +
                ", likes=" + likes +
                '}';
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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
