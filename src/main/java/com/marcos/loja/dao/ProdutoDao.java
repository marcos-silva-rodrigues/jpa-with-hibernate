package com.marcos.loja.dao;

import com.marcos.loja.modelo.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void create(Produto produto) {
        this.em.persist(produto);
    }
}
