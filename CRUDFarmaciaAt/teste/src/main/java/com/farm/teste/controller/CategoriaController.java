package com.farm.teste.controller;

import com.farm.teste.model.Categoria;
import com.farm.teste.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return (ResponseEntity<List<Categoria>>) ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable long id) {
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<Categoria> post(@RequestBody Categoria descricao) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(descricao));
    }

    @PutMapping
    public ResponseEntity<Categoria> Put(@RequestBody Categoria descricao) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(descricao));
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable long id){
        repository.deleteById(id);
    }
}