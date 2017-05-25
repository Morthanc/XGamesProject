/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.service;

import com.senac.xgames.exceptions.DataSourceException;
import com.senac.xgames.exceptions.ItemVendaException;
import com.senac.xgames.exceptions.VendaException;
import com.senac.xgames.mock.MockItemVenda;
import com.senac.xgames.model.ItemVenda;

/**
 *
 * @author magno
 */
public class ServicoItemVenda {
     //Insere um Produto na fonte de dados
    public static void cadastrarItemVenda(ItemVenda item)
            throws VendaException, DataSourceException, ItemVendaException {

        try {
            //Realiza a chamada de inserção na fonte de dados
            MockItemVenda.inserir(item);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
