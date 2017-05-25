/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author magno
 */
public class ItemVenda {
    private Integer codigo;
    private Integer codigoVenda;
    private String titulo;
    private String plataforma;
    private Integer quantidade;
    private double preco;
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(Integer codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}