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

/**
 *
 * @author magno
 */
public class ServicoVenda {
    //Insere um Produto na fonte de dados
    public static void cadastrarVenda(Venda venda)
            throws VendaException, DataSourceException, ItemVendaException {

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

}
