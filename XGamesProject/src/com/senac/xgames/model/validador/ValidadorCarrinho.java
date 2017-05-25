/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.model.validador;

import com.senac.xgames.exceptions.CarrinhoException;
import com.senac.xgames.model.Carrinho;

/**
 *
 * @author Magno
 */
public class ValidadorCarrinho {
    //Realização da validação de negocio
    public static void validar(Carrinho carrinho)throws Exception, CarrinhoException{
        
        if(carrinho == null){
            throw new CarrinhoException("É preciso informar um produto para o carrinho!");
        }
        
        if(carrinho.getQuantidade() == null || carrinho.getQuantidade() == 0){
            throw new CarrinhoException("É preciso informar uma quantidade no carrinho!");
        }
    }
}
