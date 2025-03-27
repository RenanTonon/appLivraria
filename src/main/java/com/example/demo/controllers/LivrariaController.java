package com.example.demo.controllers;

import com.example.demo.dto.LivrariaDto;
import com.example.demo.model.Livraria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.LivrariaServices;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/livros")
public class LivrariaController {

    @Autowired
    LivrariaServices livrariaServices;

    @PostMapping
    public ResponseEntity<Livraria> createLivraria(@RequestBody LivrariaDto modelLivraria){
        Livraria livro = livrariaServices.createLivraria(modelLivraria);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(modelLivraria.getAuthor())
                .toUri();
        return ResponseEntity.created(uri).body(livro);
    }

    @GetMapping
    private ResponseEntity<List<Livraria>> findAll(){
        List<Livraria> livro = livrariaServices.findAll();
        return ResponseEntity.status(200).body(livro);
        /// 200
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteLivro(@RequestParam Long id){
        ResponseEntity livro = livrariaServices.deleteLivro(id);
        return ResponseEntity.status(204).body(livro);
        /// 204
    }
    @PatchMapping("/{id}")
    private ResponseEntity uptadeLivro(@RequestBody LivrariaDto livroDto, @RequestParam Long id){
        Livraria livro = livrariaServices.uptadeLivro(livroDto,id);
        return ResponseEntity.status(203).body(livro);
    }

}
