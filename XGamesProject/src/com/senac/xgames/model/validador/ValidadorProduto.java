/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.model.validador;
import com.senac.xgames.exceptions.ProdutoException;
import com.senac.xgames.model.Produto;
/**
 *
 * @author Magno
 */
public class ValidadorProduto {
    //Realização de validação de negócio
    public static void validar(Produto produto) throws ProdutoException{
        
        if(produto == null){
            throw new ProdutoException("Não foi informado um produto");
        }
        
         if(produto.getTitulo() == null || "".equals(produto.getTitulo())){
            throw new ProdutoException("Não foi informado um título");
        }
         
          if(produto.getCategoria() == null || "".equals(produto.getCategoria())){
            throw new ProdutoException("Não foi informada uma categoria");
        }
          
           if(produto.getEstoque()== null || "".equals(produto.getEstoque())){
            throw new ProdutoException("Não foi informado o valor de estoque");
        }
           
           try {
            String.valueOf(produto.getEstoque());
        }  catch (NumberFormatException e) {
            throw new ProdutoException("É necessário digitar somente "
                    + "números para alimentar o estoque" + e);
        }
             
            
            if(produto.getPreco()== null || "".equals(produto.getPreco())){
            throw new ProdutoException("Não foi informado o preço do produto");
        }
            
               try {
                produto.getPreco();
        }  catch (NumberFormatException e) {
            throw new ProdutoException("É necessário digitar somente "
                    + "números para preço" + e);
        }
           
           if(produto.getPlataforma()== null || "".equals(produto.getPlataforma())){
            throw new ProdutoException("Não foi informada a plataforma do produto");
        }
            
    }
}
