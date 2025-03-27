package com.example.demo.dto;

public class LivrariaDto {
    private Long id;
    private String name;
    private String author;

    public LivrariaDto(
        Long id,
        String name,
        String author
    ) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Long id(){
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getAuthor() {
        return this.author;
    }


}
