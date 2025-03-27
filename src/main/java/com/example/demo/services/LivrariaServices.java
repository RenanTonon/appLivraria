package com.example.demo.services;

import com.example.demo.dto.LivrariaDto;
import com.example.demo.model.Livraria;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.repository.LivrariaRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class LivrariaServices {
    @Autowired
    LivrariaRepository repositorio;

    public Livraria createLivraria(LivrariaDto livro){
       Livraria book = new Livraria();
       book.setName(livro.getName());
       book.setAuthor(livro.getAuthor());

       return this.repositorio.save(book);
    }

    public List<Livraria> findAll(){
        return this.repositorio.findAll();
    }

    public ResponseEntity deleteLivro(Long id){
         repositorio.deleteById(id);
         return new ResponseEntity(HttpStatus.OK);
    }

    public Livraria uptadeLivro(LivrariaDto livro, Long id) {
        Optional<Livraria> livro2 = repositorio.findById(id);
        if(livro2.isEmpty()){
            throw new RuntimeException("");

        }
        Livraria book = new Livraria();
        book.setId(id);
        book.setName(livro.getName());
        book.setAuthor(livro.getAuthor());
        return repositorio.save(book);
    }
}
