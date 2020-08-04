package com.example.ExplMarc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="tb_aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 5,max = 100)
    private String nome;
    @NotNull
    private boolean matriculado;

    @ManyToOne
    @JsonIgnoreProperties("turma")
    private Turma turma;

    /*@OneToMany(mappedBy = "aluno",cascade = CascadeType.ALL)
    private List<Turma> turma;
    @JsonIgnoreProperties("aluno")*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMatriculado() {
        return matriculado;
    }

    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }
}
