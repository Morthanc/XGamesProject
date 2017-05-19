/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author magno
 */
public class Venda {
    private Integer codigo;
    private String nomeCliente;
    private Date data;
    private String Hora;
    private Double valorTotal;
    private List<ItemVenda> listaItemVenda= new ArrayList<ItemVenda>();
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemVenda> getListaItemReserva() {
        return listaItemVenda;
    }

    public void setListaItemReserva(List<ItemVenda> listaItemReserva) {
        this.listaItemVenda = listaItemReserva;
    }
    
    
    
}
