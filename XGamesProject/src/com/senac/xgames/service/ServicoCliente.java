/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.service;
import com.senac.xgames.dao.ClienteDAO;
import com.senac.xgames.exceptions.ClienteException;
import com.senac.xgames.model.Cliente;
import com.senac.xgames.model.validador.ValidadorCliente;
import com.senac.xgames.mock.MockCliente;
import com.senac.xgames.exceptions.DataSourceException;
import java.util.List;
/**
 *
 * @author magno
 */

//Classe de servico do cliente
public class ServicoCliente {
     ClienteDAO clienteDAO = new ClienteDAO();
     

    public void cadastrarCliente(Cliente cliente) throws ClienteException, DataSourceException, Exception {

        ValidadorCliente.validar(cliente);

        try {
            clienteDAO.inserirCliente(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Atualiza um cliente na fonte de dados
    public void atualizarCliente(Cliente cliente) throws ClienteException, DataSourceException, Exception {
        
        //ValidadorCliente.validar(cliente);

        try {
            clienteDAO.updateCliente(cliente);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Realiza a pesquisa de um cliente por nome na fonte de dados
    public List<Cliente> procurarCliente(String nome) throws ClienteException, DataSourceException, Exception {
        try {

            if (nome == null || "".equals(nome)) {
                throw new Exception("Campo nome vazio!");
            } else {
                return clienteDAO.listarCliente(nome);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //Realiza a pesquisa de um cliente por nome na fonte de dados
    public Cliente obterClientePorCpf(String cpf) throws ClienteException, DataSourceException, Exception {
        try {
            if (cpf == null || "".equals(cpf)) {
                throw new Exception("Campo nome vazio!");
            } else {
                return clienteDAO.encontrarClientePorCpf(cpf);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Obtem o cliente com ID informado do mock
    public static Cliente obterCliente(Integer id)
            throws ClienteException, DataSourceException, Exception {
        try {
            //Retorna o cliente obtido com o DAO
            return MockCliente.obter(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Exclui o cliente com ID informado do mock
    public void excluirCliente(String cpf) throws ClienteException, DataSourceException, Exception {
        try {
            //Solicita ao DAO a exclusão do cliente informado
            clienteDAO.deletarCliente(cpf);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
