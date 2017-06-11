/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.dao;

import com.senac.xgames.model.Produto;
import com.senac.xgames.model.produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *       private Integer id;
    private Integer codigo;
    private String titulo;
    private String desenvolvedor;
    private String fornecedor;
    private String categoria;
    private String plataforma;
    private String genero;
    private String classificacao;
    private Double preco;
    private Integer estoque;
    private Integer quantidade = 0;
 * @author Uriel
 */
public class ProdutoDAO2 {
    public void inserirProduto(Produto produto){
        
         String query = " insert into produto (codigo, titulo, desenvolvedor, fornecedor, categoria"
                 + "plataforma, genero, classificacao, preco, estoque, quantidade)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setInt(1, produto.getCodigo());
            preparedStatement.setString(2, produto.getTitulo());
            preparedStatement.setString(3, produto.getDesenvolvedor());
            preparedStatement.setString(4, produto.getFornecedor());
            preparedStatement.setString(5, produto.getCategoria());
            preparedStatement.setString(6, produto.getPlataforma());
            preparedStatement.setString(7, produto.getGenero());
            preparedStatement.setString(8, produto.getClassificacao());
            preparedStatement.setDouble(9, produto.getPreco());
            preparedStatement.setInt(10, produto.getEstoque());
            preparedStatement.setInt(11, produto.getQuantidade());

        
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public produto updateProduto(Produto produto){
        
         String query = "update produto (codigo, titulo, desenvolvedor, fornecedor, categoria"
                 + "plataforma, genero, classificacao, preco, estoque, quantidade)"
        + " SET (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE id=?";
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setInt(1, produto.getCodigo());
            preparedStatement.setString(2, produto.getTitulo());
            preparedStatement.setString(3, produto.getDesenvolvedor());
            preparedStatement.setString(4, produto.getFornecedor());
            preparedStatement.setString(5, produto.getCategoria());
            preparedStatement.setString(6, produto.getPlataforma());
            preparedStatement.setString(7, produto.getGenero());
            preparedStatement.setString(8, produto.getClassificacao());
            preparedStatement.setDouble(9, produto.getPreco());
            preparedStatement.setInt(10, produto.getEstoque());
            preparedStatement.setInt(11, produto.getQuantidade());
            preparedStatement.setInt(12, produto.getId());
            
                preparedStatement.executeUpdate();
                preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO2.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return produto;
    
    }
    
    public produto listarProduto(Produto produto){
        
         String query = "SELECT FROM produto WHERE titulo=?";//addicionar o % %
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setString(1, produto.getTitulo());
            
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                produto.setTitulo(rs.getString(1));
                
                //..etc..
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO2.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return produto;
    
    }
    
        public void deletarProduto(Produto produto){
        
         String query = "DELETE FROM produto WHERE codigo=?";
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setInt(1, produto.getCodigo());
            
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
