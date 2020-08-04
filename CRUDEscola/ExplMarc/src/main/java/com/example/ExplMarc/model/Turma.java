package com.example.ExplMarc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 5,max = 100)
    private String turma;

    @NotNull
    private boolean ativo;

   /* @ManyToOne
    @JsonIgnoreProperties("turma")
    private Aluno aluno;*/

    @OneToMany(mappedBy = "turma",cascade = CascadeType.ALL)
    private List<Aluno> aluno;
    @JsonIgnoreProperties("turma")

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;

    }
    public long getId() {
        return id;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;*/
}
