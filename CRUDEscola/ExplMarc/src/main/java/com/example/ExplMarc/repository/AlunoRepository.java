package com.example.ExplMarc.repository;

import com.example.ExplMarc.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    public List<Aluno> findAllByNomeContainingIgnoreCase (String nome);
}
