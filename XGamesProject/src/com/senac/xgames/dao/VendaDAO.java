/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.dao;

import com.senac.xgames.model.Venda;
import com.senac.xgames.utils.ConexaoBanco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author Uriel
 */
public class VendaDAO {
        ConexaoBanco conexaoBanco = new ConexaoBanco();    
        Connection conn = conexaoBanco.createConnection();
        
    public void cadastrarVenda(Venda venda){
                 String query = " insert into venda (codigo,id_cliente, id_produto, data, valorTotal )"
        + " values (?, ?, ?, ?, ?)";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, venda.getCodigo());
            preparedStatement.setObject(2, venda.getCliente());
            preparedStatement.setObject(3, venda.getProduto());
            preparedStatement.setDate(4,(Date) venda.getData());
            preparedStatement.setDouble(5,venda.getValorTotal());


        
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar venda");
        }
    }
}
