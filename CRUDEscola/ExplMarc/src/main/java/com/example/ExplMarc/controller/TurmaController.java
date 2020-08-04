package com.example.ExplMarc.controller;
import com.example.ExplMarc.model.Turma;
import com.example.ExplMarc.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
@CrossOrigin("*")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @GetMapping
    public ResponseEntity<List<Turma>> getAllTurma(){
        return (ResponseEntity<List<Turma>>) ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getByIdTurma(@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<Turma> Post(@RequestBody Turma turma){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(turma));
    }

    @PutMapping
    public ResponseEntity<Turma> Put(@RequestBody Turma turma) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(turma));
    }
    @DeleteMapping("/{id}")
    public void Delete (@PathVariable long id) {
        repository.deleteById(id);
    }
}

