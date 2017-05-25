/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.mock;

import com.senac.xgames.model.ItemVenda;
import com.senac.xgames.model.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magno
 */
public class MockVenda {
    //Variável serve para controlar o número de venda
    private static int totalVenda = 0;
    
    //Armazena uma lista de vendas para manipulação no Mock
    private static List<Venda> listaVendas = new ArrayList<Venda>();
    
    //Insere uma nova venda no Mock
    public static void inserir(Venda venda) throws Exception{
        venda.setCodigo(totalVenda++);
        listaVendas.add(venda);
    }
    
    //Lista todas as Vendas
    public static List<Venda> listar()
            throws Exception {       
        //Retorna a lista de Vendas
        return listaVendas;
    }
    

    
    
    
    
}
