package com.marcos.loja.dao;

import com.marcos.loja.modelo.Produto;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void create(Produto produto) {
        this.em.persist(produto);
    }

    public Produto findById(Long id) {
        return this.em.find(Produto.class, id);
    }

    public List<Produto> findAll() {
        String jpql = "SELECT p FROM Produto p";
        return this.em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> findByName(String nome) {
        String jpql = "SELECT p FROM Produto p where p.nome = :nome";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> findByCategoryName(String nome) {
        String jpql = "SELECT p FROM Produto p  where p.categoria.nome = :nome";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public BigDecimal findPriceByName(String nome) {
        String jpql = "SELECT p.preco FROM Produto p where p.nome = :nome";
        return this.em.createQuery(jpql, BigDecimal.class)
                .setParameter("name", nome)
                .getSingleResult();
    }

}
