/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.dao;

import com.senac.xgames.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *    private String nome;
    private String sobrenome;
    private String sexo;
    private String rg;
    private String cpf;
    private String idade;
    private String telefone1;
    private String telefone2;
    private String email;
    private String logradouro;
    private String bairro;
    private String complemento;
    private String cep;
    private String numero;
    private String cidade;
    private String estado;
 * @author Uriel
 */
public class ClienteDAO2 {
    public void inserirCliente(Cliente cliente){
        
         String query = " insert into cliente (nome, sobrenome, sexo, rg, cpf, idade, telefone1, telefone2, email"
                 + "logradouro, bairro, complemento, cep, numero, cidade, estado)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setString(3, cliente.getSexo());
            preparedStatement.setString(4, cliente.getRg());
            preparedStatement.setString(5, cliente.getCpf());
            preparedStatement.setString(6, cliente.getIdade());
            preparedStatement.setString(7, cliente.getTelefone1());
            preparedStatement.setString(8, cliente.getTelefone2());
            preparedStatement.setString(9, cliente.getEmail());
            preparedStatement.setString(10, cliente.getLogradouro());
            preparedStatement.setString(11, cliente.getBairro());
            preparedStatement.setString(12, cliente.getComplemento());
            preparedStatement.setString(13, cliente.getCep());
            preparedStatement.setString(14, cliente.getNumero());
            preparedStatement.setString(15, cliente.getCidade());
            preparedStatement.setString(16, cliente.getEstado());
        
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cliente updateCliente(Cliente cliente){
        
         String query = "update cliente (id, nome, sobrenome, sexo, rg, cpf, idade, telefone1, telefone2, email"
                 + "logradouro, bairro, complemento, cep, numero, cidade, estado)"
        + " SET (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE id=?";
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setString(3, cliente.getSexo());
            preparedStatement.setString(4, cliente.getRg());
            preparedStatement.setString(5, cliente.getCpf());
            preparedStatement.setString(6, cliente.getIdade());
            preparedStatement.setString(7, cliente.getTelefone1());
            preparedStatement.setString(8, cliente.getTelefone2());
            preparedStatement.setString(9, cliente.getEmail());
            preparedStatement.setString(10, cliente.getLogradouro());
            preparedStatement.setString(11, cliente.getBairro());
            preparedStatement.setString(12, cliente.getComplemento());
            preparedStatement.setString(13, cliente.getCep());
            preparedStatement.setString(14, cliente.getNumero());
            preparedStatement.setString(15, cliente.getCidade());
            preparedStatement.setString(16, cliente.getEstado());
            preparedStatement.setInt(17, cliente.getId());
            
                preparedStatement.executeUpdate();
                preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO2.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return cliente;
    
    }
    
    public Cliente listarCliente(Cliente cliente){
        
         String query = "SELECT FROM cliente WHERE cpf=?";
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setString(1, cliente.getCpf());
            
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                cliente.setNome(rs.getString(1));
                
                //..etc..
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO2.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return cliente;
    
    }
    
        public void deletarCliente(Cliente cliente){
        
         String query = "DELETE FROM cliente WHERE cpf=?";
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setString(1, cliente.getCpf());
            
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
