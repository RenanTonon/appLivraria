package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Livraria {

    public Livraria(){

    }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String author;

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setAuthor(String author){
        this.author = author;
    }
}
