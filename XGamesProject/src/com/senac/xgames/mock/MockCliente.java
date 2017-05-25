package com.senac.xgames.mock;

import com.senac.xgames.model.Cliente;
import java.util.ArrayList;
import java.util.List;

//Mock de Cliente. Realiza operações de mock com o cliente. 
public class MockCliente {
    private static int totalClientes = 0;
    /** Armazena a lista de clientes inseridos para manipulação. #MOCK **/    
    private static List<Cliente> listaClientes = new ArrayList<Cliente>();
    
    //Insere um cliente no mock "listaClientes"
    public static void inserir(Cliente cliente) throws Exception {
        cliente.setId(totalClientes++);
        listaClientes.add(cliente);
    }

    //Realiza a atualização dos dados de um cliente, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Cliente"
    public static void atualizar(Cliente clienteProcura) throws Exception {
        if (clienteProcura != null && !listaClientes.isEmpty()) {
            for (Cliente cliente : listaClientes) {
                if (cliente != null && cliente.getId() == clienteProcura.getId()) {
                    cliente.setCpf(clienteProcura.getCpf());
                    cliente.setIdade(clienteProcura.getIdade());
                    cliente.setNome(clienteProcura.getNome());
                    cliente.setRg(clienteProcura.getRg());
                    cliente.setEmail(clienteProcura.getEmail());
                    cliente.setTelefone1(clienteProcura.getTelefone1());
                    cliente.setTelefone2(clienteProcura.getTelefone2());
                break;
                }
            }
        }
    }

    //Realiza a exclusão de um cliente no mock, com ID fornecido
    //como parâmetro.
    public static void excluir(Integer id) throws Exception {
        if (id != null && !listaClientes.isEmpty()) {
            for (int i = 0; i < listaClientes.size(); i++) {
                Cliente clienteLi = listaClientes.get(i);
                if (clienteLi != null && clienteLi.getId() == id) {
                    listaClientes.remove(i);
                    break;
                }
            }
        }
    }

    //Lista todos os clientes
    public static List<Cliente> listar()
            throws Exception {       
        //Retorna a lista de clientes
        return listaClientes;
    }

    //Procura um cliente no mock, de acordo com o nome
    //ou com o sobrenome, passado como parâmetro
    public static List<Cliente> procurar(String valor)
            throws Exception {
        List<Cliente> listaResultado = new ArrayList<Cliente>();
        
        if (valor != null && !listaClientes.isEmpty()) {
            for (Cliente cliente : listaClientes) {

                    if (cliente.getNome().toUpperCase().contains(valor.toUpperCase())) {
                        listaResultado.add(cliente);
                    }
                
            }
        }
        
        //Retorna a lista de clientes encontrados
        return listaResultado;
    }
    
     //Procura um cliente no mock, de acordo com o nome
    //ou com o sobrenome, passado como parâmetro
    public static List<Cliente> procurarCPF(String cpf)
            throws Exception {
        List<Cliente> listaResultado = new ArrayList<Cliente>();
        
        if (cpf != null && !listaClientes.isEmpty()) {
            for (Cliente cliente : listaClientes) {

                    if (cliente.getCpf().toUpperCase().contains(cpf.toUpperCase())) {
                        listaResultado.add(cliente);
                    }
                
            }
        }
        
        //Retorna a lista de clientes encontrados
        return listaResultado;
    }

    //Obtém um cliente da lista
    public static Cliente obter(Integer id)
            throws Exception {
        if (id != null && !listaClientes.isEmpty()) {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i) != null && listaClientes.get(i).getId() == id) {
                    return listaClientes.get(i);
                }                
            }
        }
        return null;
    }
}