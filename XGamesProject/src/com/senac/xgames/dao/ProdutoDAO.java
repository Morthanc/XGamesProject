package com.senac.xgames.dao;

import com.senac.xgames.model.Produto;
import com.senac.xgames.utils.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
        ConexaoBanco conexaoBanco = new ConexaoBanco();    
        Connection conn = conexaoBanco.createConnection();
        
    public void inserirProduto(Produto produto){
        
         String query = "insert into produto (codigo, titulo, desenvolvedor, fornecedor, categoria,plataforma, genero, classificacao, preco, estoque) values (?,?,?,?,?,?,?,?,?,?);";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
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
            

        
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Erro ao salvar produto");
        }
    }
    
    public Produto updateProduto(Produto produto){
        
         String query = "update produto (codigo, titulo, desenvolvedor, fornecedor, categoria"
                 + "plataforma, genero, classificacao, preco, estoque, quantidade)"
        + " SET (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE id=?";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
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
            preparedStatement.setInt(11, produto.getId());
            
                preparedStatement.executeUpdate();
                preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar produto");
        }

        
        return produto;
    
    }
    
    public Produto listarProduto(Produto produto){
        
         String query = "SELECT FROM produto WHERE titulo=?";//addicionar o % %
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
            preparedStatement.setString(1, produto.getTitulo());
            
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                produto.setTitulo(rs.getString(1));
                
                //..etc..
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar produto");
        }

        
        return produto;
    
    }
    
        public void deletarProduto(Produto produto){
        
         String query = "DELETE FROM produto WHERE codigo=?";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
            preparedStatement.setInt(1, produto.getCodigo());
            
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar produto");
        }
    }
}
