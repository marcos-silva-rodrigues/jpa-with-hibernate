package com.marcos.loja.dao;

import com.marcos.loja.modelo.Cliente;
import com.marcos.loja.modelo.Pedido;
import com.marcos.loja.modelo.Produto;
import jakarta.persistence.EntityManager;

public class ClienteDao {

    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void create(Cliente cliente) {
        this.em.persist(cliente);
    }

    public Cliente findById(Long id) {
        return this.em.find(Cliente .class, id);
    }

}
