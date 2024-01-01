package com.marcos.loja.dao;

import com.marcos.loja.modelo.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void create(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void update(Categoria categoria) {
        this.em.merge(categoria);
    }

    public void remove(Categoria categoria) {
        var managedState = this.em.merge(categoria);
        this.em.remove(managedState);
    }
}
