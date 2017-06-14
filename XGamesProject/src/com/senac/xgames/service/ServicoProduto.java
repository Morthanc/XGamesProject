/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.service;
import com.senac.xgames.dao.ProdutoDAO;
import com.senac.xgames.exceptions.ProdutoException;
import com.senac.xgames.model.Produto;
import com.senac.xgames.model.validador.ValidadorProduto;
import com.senac.xgames.mock.MockProduto;
import com.senac.xgames.exceptions.DataSourceException;
import java.util.List;
/**
 *
 * @author magno
 */
//Classe de Servico de Produto
public class ServicoProduto {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public void cadastrarProduto(Produto produto) throws ProdutoException, DataSourceException {
        
        ValidadorProduto.validar(produto);

        try {
            //Realiza a chamada de inserção na fonte de dados
            produtoDAO.inserirProduto(produto);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Atualiza um produto na fonte de dados
    public void atualizarProduto(Produto produto) throws ProdutoException, DataSourceException {
        ValidadorProduto.validar(produto);

        try {
            produtoDAO.updateProduto(produto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }


    public  List<Produto> procurarProduto(String nome) throws ProdutoException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do mock.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            if (nome == null || "".equals(nome)) {
                return MockProduto.listar();
            } else {
                 return produtoDAO.listarProduto(nome);
            }
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    


    public Produto encontrarProdutoPorCodigo(int codigo) throws ProdutoException, DataSourceException {
        try {
            return produtoDAO.encontrarProduto(codigo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public void excluirProduto(Integer codigo) throws ProdutoException, DataSourceException {
        try {
            produtoDAO.deletarProduto(codigo);
        } catch (Exception e) {
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public void atualizaEstoque(int codigo, int estoque) throws ProdutoException, DataSourceException {
        try {
            produtoDAO.atualizarEstoque(codigo, estoque);
        } catch (Exception e) {
            throw new DataSourceException("Erro na fonte de dados", e);
        }
}
}
