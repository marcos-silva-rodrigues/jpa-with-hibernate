package com.marcos.loja.modelo;

public class Livro {

    private String author;
    private Integer numerosDePaginas;

    public Livro(String author, Integer numerosDePaginas) {
        this.author = author;
        this.numerosDePaginas = numerosDePaginas;
    }

    public Livro() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumerosDePaginas() {
        return numerosDePaginas;
    }

    public void setNumerosDePaginas(Integer numerosDePaginas) {
        this.numerosDePaginas = numerosDePaginas;
    }
}
