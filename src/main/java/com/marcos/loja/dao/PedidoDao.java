package com.marcos.loja.dao;

import com.marcos.loja.modelo.Pedido;
import com.marcos.loja.modelo.Produto;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {

    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void create(Pedido pedido) {
        this.em.persist(pedido);
    }

}
