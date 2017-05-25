/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.mock;

import com.senac.xgames.model.Carrinho;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magno
 */
public class MockCarrinho {
    //Cria uma lista para carrinho
    public static List <Carrinho> Listacarrinho = new ArrayList<Carrinho>();
    
    //Variável serve verificar total de produtos
    private static int totalProdutosCarrinho = 0;
    
    //Insere um Produto no mock "Carrinho"
   public static void inserir(Carrinho carrinho) throws Exception{
       carrinho.setId(totalProdutosCarrinho++);
       Listacarrinho.add(carrinho);
   }
   
   public static List<Carrinho> listar(){
       return Listacarrinho;
   }
}
