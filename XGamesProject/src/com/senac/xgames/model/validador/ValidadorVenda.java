/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.model.validador;
import com.senac.xgames.exceptions.ClienteException;
import com.senac.xgames.exceptions.VendaException;
import com.senac.xgames.exceptions.ProdutoException;
import com.senac.xgames.exceptions.ItemVendaException;
import com.senac.xgames.model.Cliente;
import com.senac.xgames.model.Venda;
import com.senac.xgames.model.ItemVenda;
import com.senac.xgames.model.Produto;
/**
 *
 * @author Magno
 */
public class ValidadorVenda {
    public static Cliente cliente = new Cliente();
    public static ItemVenda itemvenda = new ItemVenda();
    public static Produto produto = new Produto();
    
    public static void validar(Venda venda) throws VendaException, ClienteException, ItemVendaException, ProdutoException{
        
         if(cliente == null){
            throw new ClienteException("Não foi informado um cliente");
        }
         
         if(itemvenda == null){
             throw new ItemVendaException("Não foi adicionado um produto");
         }
         
         if(produto.getEstoque() == 0 || produto.getEstoque() == null){
             throw  new ProdutoException("Não existe o produto em estoque");
         }
         
         
         
        
    }
    
}
