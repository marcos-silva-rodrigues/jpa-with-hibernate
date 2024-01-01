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

    public List<Produto> findByName(String name) {
        String jpql = "SELECT p FROM Produto p where p.nome = :name";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Produto> findByCategoryName(String name) {
        String jpql = "SELECT p FROM Produto p  where p.categoria.name = :name";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("name", name)
                .getResultList();
    }

    public BigDecimal findPriceByName(String name) {
        String jpql = "SELECT p.preco FROM Produto p where p.nome = :name";
        return this.em.createQuery(jpql, BigDecimal.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
