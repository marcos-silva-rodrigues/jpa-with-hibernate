package com.marcos.loja.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @EmbeddedId
    private CategoriaId id;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.id = new CategoriaId(nome, "XPTO");
    }

    public String getNome() {
        return this.id.getNome();
    }

    public void setNome(String nome) {
        this.id.setNome(nome);
    }

    public String getTipo() {
        return this.id.getTipo();
    }

    public void setTipo(String tipo) {
        this.id.setTipo(tipo);
    }
}
