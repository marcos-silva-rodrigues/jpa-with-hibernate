package com.marcos.loja.modelo;

import java.time.LocalDate;

public class Venda {

    private String nomeProduto;
    private Long quantidade;

    private LocalDate data;

    public Venda() {
    }

    public Venda(String nomeProduto, Long quantidade, LocalDate data) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.data = data;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nome) {
        this.nomeProduto = nome;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", quantidade=" + quantidade +
                ", data=" + data +
                '}';
    }
}
