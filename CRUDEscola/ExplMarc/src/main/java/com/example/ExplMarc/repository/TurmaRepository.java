package com.example.ExplMarc.repository;
import com.example.ExplMarc.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    public List<Turma> findAllByTurmaContainingIgnoreCase (String turma);
}
