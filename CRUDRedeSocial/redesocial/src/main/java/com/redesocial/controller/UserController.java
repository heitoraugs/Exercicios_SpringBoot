package com.redesocial.controller;

import com.redesocial.model.Postage;
import com.redesocial.model.User;
import com.redesocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return (ResponseEntity<List<User>>) ResponseEntity.ok(repository.findAll());
    }
    @PostMapping
    public ResponseEntity<User> post(@RequestBody User name){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(name));
    }
    @PutMapping
    public ResponseEntity<User> put(@RequestBody User name){
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(name));
    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable long id){
        repository.deleteById(id);
    }
}
