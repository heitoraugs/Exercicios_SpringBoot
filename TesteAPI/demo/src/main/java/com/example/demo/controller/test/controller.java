package com.example.demo.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class controller {

    @GetMapping
    public String primeiraMsg(){
        return "Essa atividade com certeza demandou muita persistência.";
    }
}
