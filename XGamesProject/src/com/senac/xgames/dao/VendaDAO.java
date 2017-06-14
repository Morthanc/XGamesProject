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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author Uriel
 */
public class VendaDAO {
        ConexaoBanco conexaoBanco = new ConexaoBanco();    
        Connection conn = conexaoBanco.createConnection();
        
    public Integer cadastrarVenda(Venda venda){
                 String query = " insert into venda (idcliente, data, valorTotal )"
        + " values (?, ?, ?)";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, venda.getCliente().getId());
            preparedStatement.setObject(2,venda.getData());
            preparedStatement.setDouble(3,venda.getValorTotal());
            
            preparedStatement.executeUpdate();
            
            ResultSet  rs = preparedStatement.getGeneratedKeys();
            rs.next();
            preparedStatement.close();
            return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar venda");
            return null;
        }
    }
}
