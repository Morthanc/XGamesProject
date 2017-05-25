/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.mock;

import com.senac.xgames.model.ItemVenda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magno
 */
public class MockItemVenda {
    //Variável serve para controlar o número de itens
    private static int totalItemVenda = 0;
    
    //Armazena uma lista de vendas para manipulação no Mock
    private static List<ItemVenda> listaItemVendas = new ArrayList<ItemVenda>();
    
    //Insere uma nova venda no Mock
    public static void inserir(ItemVenda item) throws Exception{
        item.setCodigo(totalItemVenda++);
        listaItemVendas.add(item);
    }
    
    //Lista todas as Vendas
    public static List<ItemVenda> listar()
            throws Exception {       
        //Retorna a lista de Vendas
        return listaItemVendas;
    }
    
}
