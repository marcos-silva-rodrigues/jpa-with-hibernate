package com.marcos.loja;

import com.marcos.loja.dao.CategoriaDao;
import com.marcos.loja.dao.ProdutoDao;
import com.marcos.loja.modelo.Categoria;
import com.marcos.loja.modelo.Produto;
import com.marcos.loja.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Teste", new BigDecimal("1200"), celulares);

        EntityManager em = new JpaUtil().getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.create(celulares);
        produtoDao.create(celular);

        em.flush();
        em.clear();

        // retorna o modelo de DETACHED para MANAGED através de uma nova
        // referência
        celulares = em.merge(celulares);
        celulares.setName("PHONES");
        em.flush();
    }
}