/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.model.validador;

import com.senac.xgames.exceptions.ItemVendaException;
import com.senac.xgames.exceptions.VendaException;
import com.senac.xgames.model.ItemVenda;

/**
 *
 * @author magno
 */
public class ValidadorItemVenda {
    
    public static void validar(ItemVenda item) throws VendaException, ItemVendaException{
        
         if(item.getCodigo()== null){
            throw new ItemVendaException("Não foi informado um produto!");
        }
         
         if(item.getPlataforma() == null){
              throw new ItemVendaException("Não foi informada a plataforma do item!");
         }
         
          if(item.getPreco() == 0){
              throw new ItemVendaException("Não foi informado o preço do item!");
         }
          
          if(item.getQuantidade()== null){
              throw new ItemVendaException("Não foi informada a quantidade do item!");
         }
          
          if(item.getTitulo() == null){
              throw new ItemVendaException("Não foi informado o Título do item!");
         }
        
    }
}
