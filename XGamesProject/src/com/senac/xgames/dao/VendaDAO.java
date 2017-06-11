/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.dao;

import com.senac.xgames.model.Venda;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *    private Integer codigo;
    private Cliente cliente;
    public List<Produto> produto = new ArrayList<Produto>();
    private Date data;
    private Double valorTotal;
 * @author Uriel
 */
public class VendaDAO {
    public void cadastrarVenda(Venda venda){
                 String query = " insert into venda (codigo,id_cliente, id_produto, data, valorTotal )"
        + " values (?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setInt(1, venda.getCodigo());
            preparedStatement.setObject(2, venda.getCliente());
            preparedStatement.setObject(3, venda.getProduto());
            preparedStatement.setDate(4,(Date) venda.getData());
            preparedStatement.setDouble(5,venda.getValorTotal());


        
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
