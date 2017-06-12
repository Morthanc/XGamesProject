/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.dao;

import com.senac.xgames.model.Cliente;
import com.senac.xgames.utils.ConexaoBanco; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoinformacao
 */
public class ClienteDAO {
    ConexaoBanco conexaoBanco = new ConexaoBanco();
    
    Connection conn = conexaoBanco.createConnection();
    

    public void inserirCliente(Cliente cliente){
        
         String query = " insert into cliente (nome, sobrenome, sexo, cpf, rg, idade, telefone1, telefone2, email,"
                 + "bairro, cep, complemento, logradouro, numero, cidade, estado)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setString(3, cliente.getSexo());
            preparedStatement.setString(4, cliente.getCpf());
            preparedStatement.setString(5, cliente.getRg());            
            preparedStatement.setString(6, cliente.getIdade());
            preparedStatement.setString(7, cliente.getTelefone1());
            preparedStatement.setString(8, cliente.getTelefone2());
            preparedStatement.setString(9, cliente.getEmail());
            preparedStatement.setString(10, cliente.getBairro());
            preparedStatement.setString(11, cliente.getCep());
            preparedStatement.setString(12, cliente.getComplemento());
            preparedStatement.setString(13, cliente.getLogradouro());
            preparedStatement.setString(14, cliente.getNumero());
            preparedStatement.setString(15, cliente.getCidade());
            preparedStatement.setString(16, cliente.getEstado());
            
           

        
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar cliente"+ex);
        }
    }
    
    public Cliente updateCliente(Cliente cliente){
        
         String query = "update cliente (id, nome, sobrenome, sexo, rg, cpf, idade, telefone1, telefone2, email"
                 + "logradouro, bairro, complemento, cep, numero, cidade, estado)"
        + " SET (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE id=?";
        
       
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
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
           System.out.println("Erro ao salvar cliente");
        }

        
        return cliente;
    
    }
    
    public List<Cliente> listarCliente(String cpf){
        Cliente cliente = new Cliente();
        List<Cliente> lista = new ArrayList<>();
         String query = "SELECT * FROM cliente WHERE cpf=?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, cpf);
         
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                cliente.setNome(rs.getString(1));
                cliente.setSobrenome(rs.getString(2));
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Erro ao salvar cliente");
        }

        
        return lista;
    
    }
    
        public void deletarCliente(Cliente cliente){
        
         String query = "DELETE FROM cliente WHERE cpf=?";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, cliente.getCpf());
            
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar cliente");
        }
    }
}
