package com.marcos.loja.dao;

import com.marcos.loja.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.math.BigDecimal;
import java.time.LocalDate;
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
        return this.em.createNamedQuery("Produto.produtosPorCategoria", Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public BigDecimal findPriceByName(String nome) {
        String jpql = "SELECT p.preco FROM Produto p where p.nome = :nome";
        return this.em.createQuery(jpql, BigDecimal.class)
                .setParameter("name", nome)
                .getSingleResult();
    }

    public List<Produto> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro){
        String jpql = "SELECT p FROM Produto p WHERE 1=1";

        if (nome != null && !nome.trim().isEmpty()) {
            jpql += " AND p.nome = :nome";
        }

        if (preco != null) {
            jpql += " AND p.preco = :preco";
        }

        if (dataCadastro != null ) {
            jpql += " AND p.dataCadastro = :dataCadastro";
        }

        TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);

        if (nome != null && !nome.trim().isEmpty()) {
            query.setParameter("nome", nome);
        }

        if (preco != null) {
            query.setParameter("preco", preco);
        }

        if (dataCadastro != null ) {
            query.setParameter("dataCadastro", dataCadastro);
        }

        return query.getResultList();
    }

    public List<Produto> buscarPorParametrosComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> from = query.from(Produto.class);
        Predicate filters = builder.and();

        if (nome != null && !nome.trim().isEmpty()) {
            builder.and(filters, builder.equal(from.get("nome"), nome));
        }

        if (preco != null) {
            builder.and(filters, builder.equal(from.get("preco"), preco));
        }

        if (dataCadastro != null ) {
            builder.and(filters, builder.equal(from.get("dataCadastro"), dataCadastro));
        }

        query.where(filters);

        return em.createQuery(query).getResultList();
    }

}
