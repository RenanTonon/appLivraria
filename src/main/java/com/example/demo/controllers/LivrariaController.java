package com.example.demo.controllers;

import com.example.demo.model.Livraria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.LivrariaServices;

import java.util.List;


@RestController
@RequestMapping("/livros")
public class LivrariaController {

    @Autowired
    LivrariaServices livrariaServices;

    @PostMapping
    public Livraria createLivraria(@RequestBody Livraria modelLivraria){
        return livrariaServices.createLivraria(modelLivraria);
    }

    @GetMapping
    private List<Livraria> findAll(){
        return livrariaServices.findAll();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteLivro(@RequestParam Long id){
        return livrariaServices.deleteLivro(id);
    }

}
