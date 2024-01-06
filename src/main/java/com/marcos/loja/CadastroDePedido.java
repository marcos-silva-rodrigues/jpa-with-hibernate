package com.marcos.loja;

import com.marcos.loja.dao.*;
import com.marcos.loja.modelo.*;
import com.marcos.loja.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class CadastroDePedido {

    public static void main(String[] args) {

        var em = setUp();

        cadastrarProduto(em);

        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        Cliente cliente = new Cliente("Marcos", "12345657890");
        clienteDao.create(cliente);

        Pedido pedido = new Pedido(cliente);
        PedidoDao pedidoDao = new PedidoDao(em);


        Produto produto = produtoDao.findById(1l);
        ItemPedido item = new ItemPedido(1, pedido, produto);

        pedido.adicionarItem(item);
        pedidoDao.create(pedido);


       setDown(em);

    }

    private static EntityManager setUp() {
        EntityManager em = new JpaUtil().getEntityManager();
        em.getTransaction().begin();
        return em;
    }

    private static void setDown(EntityManager em) {
        em.getTransaction().commit();
        em.close();
    }

    private static void cadastrarProduto(EntityManager em) {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi", "TESTE", BigDecimal.valueOf(1200), celulares);

        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        categoriaDao.create(celulares);
        produtoDao.create(celular);
    }
}
