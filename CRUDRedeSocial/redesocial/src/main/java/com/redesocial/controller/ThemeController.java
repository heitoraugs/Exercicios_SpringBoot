package com.redesocial.controller;

import com.redesocial.model.Theme;
import com.redesocial.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theme")
@CrossOrigin("*")
public class ThemeController {
    @Autowired
    private ThemeRepository repository;

    @GetMapping
    public ResponseEntity<List<Theme>> getAll(){
        return (ResponseEntity<List<Theme>>) ResponseEntity.ok(repository.findAll());
    }
    @PostMapping
    public ResponseEntity<Theme> post(@RequestBody Theme description){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(description));
    }
    @PutMapping
    public ResponseEntity<Theme> put(@RequestBody Theme description){
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(description));
    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable long id){
        repository.deleteById(id);
    }
}
