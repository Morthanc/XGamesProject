/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.mock;
import com.senac.xgames.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoinformacao
 */

//Mock de Produto Realiza operações de Mock com o Produto.
public class MockProduto {
    //Variável serve 
    private static int totalProdutos = 0;
    
    //Armazena uma lista de produtos para manipulação no Mock
    private static List<Produto> listaProdutos = new ArrayList<Produto>();
    
    //Insere um Produto no mock "listaProdutos"
   public static void inserir(Produto produto) throws Exception{
       produto.setId(totalProdutos++);
       listaProdutos.add(produto);
   }
   
   //Realiza a atualização dos dados de um Produto, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Produto"
    public static void atualizar(Produto produtoProcura) throws Exception {
        if (produtoProcura != null && !listaProdutos.isEmpty()) {
            for (Produto produto : listaProdutos) {
                if (produto != null && produto.getId() == produtoProcura.getId()) {
                    produto.setTitulo(produtoProcura.getTitulo());
                    produto.setDesenvolvedor(produtoProcura.getDesenvolvedor());
                    produto.setFornecedor(produtoProcura.getFornecedor());
                    produto.setCategoria(produtoProcura.getCategoria());
                    produto.setPlataforma(produtoProcura.getPlataforma());
                    produto.setGenero(produtoProcura.getGenero());
                    produto.setClassificacao(produtoProcura.getClassificacao());
                    produto.setPreco(produtoProcura.getPreco());
                    produto.setEstoque(produtoProcura.getEstoque());
                break;
                }
            }
        }
    }
    
    //Remove um Produto do Mock através da passagem do parâmetro ID
    public static void excluir(Integer id) throws Exception{
        if(id != null && !listaProdutos.isEmpty()){
            for (int i = 0; i < listaProdutos.size(); i++) {
                Produto produtoCli = listaProdutos.get(i);
                if (produtoCli != null && produtoCli.getId() == id) {
                    listaProdutos.remove(i);
                    break;
                }
            }
        }
    }
    
    //Lista todos os Produtos
    public static List<Produto> listar()
            throws Exception {       
        //Retorna a lista de produtos
        return listaProdutos;
    }
    
    //Procura um cliente no mock, de acordo com o Título
    public static List<Produto> procurar(String valor) throws Exception {
        List<Produto> listaResultado = new ArrayList<Produto>();
        
        if (valor != null && !listaProdutos.isEmpty()) {
            for (Produto produtoLi : listaProdutos) {
                if (produtoLi != null && produtoLi.getTitulo()!= null) {
                    if (produtoLi.getTitulo().toUpperCase().contains(valor.toUpperCase())) {
                        listaResultado.add(produtoLi);
                    }
                }
            }
        }
        
        //Retorna a lista de Produtos encontrados
        return listaResultado;
    }
    
    //Obtém um Produto da lista
    public static Produto obter(Integer id)
            throws Exception {
        if (id != null && !listaProdutos.isEmpty()) {
            for (int i = 0; i < listaProdutos.size(); i++) {
                if (listaProdutos.get(i) != null && listaProdutos.get(i).getId() == id) {
                    return listaProdutos.get(i);
                }                
            }
        }
        return null;
    }

}
