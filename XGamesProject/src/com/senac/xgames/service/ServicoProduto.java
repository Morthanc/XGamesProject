/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.service;
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
    //Insere um Produto na fonte de dados
    public static void cadastrarProduto(Produto produto)
            throws ProdutoException, DataSourceException {

        //Chama o validador para verificar o produto
        ValidadorProduto.validar(produto);

        try {
            //Realiza a chamada de inserção na fonte de dados
            MockProduto.inserir(produto);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Atualiza um produto na fonte de dados
    public static void atualizarProduto(Produto produto)
            throws ProdutoException, DataSourceException {
        
        //Chama o validador para verificar o produto
        ValidadorProduto.validar(produto);

        try {
            //Realiza a chamada de atualização na fonte de dados
            MockProduto.atualizar(produto);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Realiza a pesquisa de um produto por nome na fonte de dados
    public static List<Produto> procurarProduto(String nome)
            throws ProdutoException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do mock.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            if (nome == null || "".equals(nome)) {
                return MockProduto.listar();
            } else {
                return MockProduto.procurar(nome);
            }
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Obtem o produto com ID informado do mock
    public static Produto obterProduto(Integer codigo)
            throws ProdutoException, DataSourceException {
        try {
            
            return MockProduto.obter(codigo);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Exclui o cliente com ID informado do mock
    public static void excluirProduto(Integer codigo)
            throws ProdutoException, DataSourceException {
        try {
            
            MockProduto.excluir(codigo);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
