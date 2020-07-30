package com.example.ExplMarc.repository;

import com.example.ExplMarc.model.EscolaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TurmaRepository extends JpaRepository<EscolaModel, Long> {

    public List<EscolaModel> findAllByTurmaContainingIgnoreCase (String turma);
}
