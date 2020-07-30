package com.example.ExplMarc.controller;
import com.example.ExplMarc.model.EscolaModel;
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
    public ResponseEntity<List<EscolaModel>> getAllTurma(){
        return (ResponseEntity<List<EscolaModel>>) ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscolaModel> getByIdTurma(@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.badRequest().build());
    }

   /* @GetMapping("/turma/{turma}")
    public ResponseEntity<List<EscolaModel>> getByTurma(@PathVariable String turma){
        return ResponseEntity.ok(repository.findAllByTurmaContainingIgnoreCase(turma));*/


    @PostMapping
    public ResponseEntity<EscolaModel> Post(@RequestBody EscolaModel turma){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(turma));
    }

    @PutMapping
    public ResponseEntity<EscolaModel> Put(@RequestBody EscolaModel turma) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(turma));
    }
    
    @DeleteMapping("/{id}")
    public void Delete (@PathVariable long id) {
        repository.deleteById(id);
    }
}

