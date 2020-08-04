package com.example.ExplMarc.controller;

import com.example.ExplMarc.model.Aluno;
import com.example.ExplMarc.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@CrossOrigin("*")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        return (ResponseEntity<List<Aluno>>) ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAllById (@PathVariable long id){
        return repository.findById(id).map(resp->ResponseEntity.ok(resp))
                .orElse((ResponseEntity.badRequest()).build());
    }
    @PostMapping
    public ResponseEntity<Aluno> post(@RequestBody Aluno nome){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(nome));
    }
    @PutMapping
    public ResponseEntity<Aluno> put(@RequestBody Aluno nome){
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(nome));
    }
    @DeleteMapping("/{id}")
    public void  Delete (@PathVariable long id){
        repository.deleteById(id);
    }
}
