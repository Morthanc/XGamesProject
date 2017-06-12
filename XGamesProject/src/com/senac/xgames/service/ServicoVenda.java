/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.service;

import com.senac.xgames.exceptions.DataSourceException;
import com.senac.xgames.exceptions.ItemVendaException;
import com.senac.xgames.exceptions.VendaException;
import com.senac.xgames.mock.MockVenda;
import com.senac.xgames.model.validador.ValidadorVenda;
import com.senac.xgames.model.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author magno
 */
public class ServicoVenda {
    public static List<Venda> listaVendas = new ArrayList<>();
    
    //Insere um Produto na fonte de dados
    public static void cadastrarVenda(Venda venda) throws VendaException, DataSourceException, ItemVendaException {

        //Chama o validador para verificar o produto
        ValidadorVenda.validar(venda);

        try {
            //Realiza a chamada de inserção na fonte de dados
            MockVenda.inserir(venda);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //Retorna lista com todas as vendas efetuadas
    public static List<Venda> listarVenda() throws DataSourceException{
        
        try {
            listaVendas = MockVenda.listar();
            
        } catch (Exception e) {
             //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
        
        return listaVendas;
    }

}
