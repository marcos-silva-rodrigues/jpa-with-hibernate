package com.marcos.loja;

import com.marcos.loja.dao.*;
import com.marcos.loja.modelo.*;
import com.marcos.loja.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class CadastroDePedido {

    public static void main(String[] args) {

        var em = setupEm();

        cadastrarProduto(em);

        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        Cliente cliente = new Cliente("Marcos", "12345657890");
        clienteDao.create(cliente);

        Pedido pedido = new Pedido(cliente);
        PedidoDao pedidoDao = new PedidoDao(em);


        Produto produto = produtoDao.findById(1l);
        ItemPedido item = new ItemPedido(2, pedido, produto);

        pedido.adicionarItem(item);
        pedidoDao.create(pedido);


        em.getTransaction().commit();

        BigDecimal valorTotal = pedidoDao.valorTotalVendido();
        System.out.println("Valor total vendido: " + valorTotal);
        em.close();

    }

    private static EntityManager setupEm() {
        EntityManager em = new JpaUtil().getEntityManager();
        em.getTransaction().begin();
        return em;
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
