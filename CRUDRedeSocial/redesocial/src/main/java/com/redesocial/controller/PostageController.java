package com.redesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.redesocial.model.Postage;
import com.redesocial.repository.PostageRepository;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/postage")
@CrossOrigin("*")
public class PostageController {
    @Autowired
    private PostageRepository repository;

    @GetMapping
    public ResponseEntity<List<Postage>> getAll(){
        return (ResponseEntity<List<Postage>>) ResponseEntity.ok(repository.findAll());
    }
    @PostMapping
    public ResponseEntity<Postage> post(@RequestBody Postage message){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(message));
    }
    @PutMapping
    public ResponseEntity<Postage> put(@RequestBody Postage message){
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(message));
    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable long id){
        repository.deleteById(id);
    }
}
