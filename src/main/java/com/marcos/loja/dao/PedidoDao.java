package com.marcos.loja.dao;

import com.marcos.loja.modelo.Pedido;
import com.marcos.loja.modelo.Produto;
import com.marcos.loja.modelo.Venda;
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

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return this.em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public List<Venda> relatorioDeVendas() {
        String jpql = """
                SELECT new com.marcos.loja.modelo.Venda(
                    produto.nome, 
                    SUM(item.quantidade), 
                    MAX(pedido.dataCadastro) 
                )
                FROM Pedido pedido 
                JOIN pedido.itens item
                JOIN item.produto produto
                GROUP BY produto.nome
                ORDER BY item.quantidade DESC
                """;
        return em.createQuery(jpql, Venda.class).getResultList();
    }

}
