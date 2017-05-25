/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.model.validador;
import com.senac.xgames.exceptions.VendaException;
import com.senac.xgames.exceptions.ItemVendaException;
import com.senac.xgames.model.Venda;
import com.senac.xgames.model.ItemVenda;

/**
 *
 * @author Magno
 */
public class ValidadorVenda {
    public static ItemVenda itemvenda = new ItemVenda();
    
    public static void validar(Venda venda) throws VendaException, ItemVendaException{
        
         if(venda.getNomeCliente() == null){
            throw new VendaException("Não foi informado um cliente");
        }
         
         if(venda.getListaItemVenda() == null){
             throw new VendaException("Não foi adicionado nenhum produto");
         }     
         
        
    }
    
}
