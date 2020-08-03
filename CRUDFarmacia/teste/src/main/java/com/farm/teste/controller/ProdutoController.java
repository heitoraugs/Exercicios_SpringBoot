package com.farm.teste.controller;

import com.farm.teste.model.Produto;
import com.farm.teste.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return (ResponseEntity<List<Produto>>)ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable long id){
        return repository.findById(id)
                .map(resp->ResponseEntity.ok(resp))
                .orElse(ResponseEntity.badRequest().build());
    }
    @PostMapping
    public ResponseEntity<Produto> post(@RequestBody Produto nome){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(nome));
    }
    @PutMapping
    public ResponseEntity<Produto> put(@RequestBody Produto nome){
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(nome));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }

}
