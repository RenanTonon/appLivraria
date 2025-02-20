package com.example.demo.services;

import com.example.demo.model.Livraria;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.repository.LivrariaRepository;

import java.util.List;

@Service
public class LivrariaServices {
    @Autowired
    LivrariaRepository repositorio;

    public Livraria createLivraria(Livraria livro){
       return repositorio.save(livro);
    }

    public List<Livraria> findAll(){
        return repositorio.findAll();
    }

    public ResponseEntity deleteLivro(Long id){
         repositorio.deleteById(id);
         return new ResponseEntity(HttpStatus.OK);
    }
}
