/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.tela;
import com.senac.xgames.exceptions.ProdutoException;
import com.senac.xgames.exceptions.VendaException;
import com.senac.xgames.model.Carrinho;
import com.senac.xgames.model.Cliente;
import com.senac.xgames.model.ItemVenda;
import com.senac.xgames.model.Produto;
import com.senac.xgames.model.Venda;
import com.senac.xgames.model.validador.ValidadorCarrinho;
import com.senac.xgames.model.validador.ValidadorVenda;
import com.senac.xgames.service.ServicoProduto;
import com.senac.xgames.service.ServicoCarrinho;
import com.senac.xgames.service.ServicoCliente;
import com.senac.xgames.service.ServicoVenda;
import static com.senac.xgames.tela.TelaVenda.servicoCarrinho;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author geoinformacao
 */
public class TelaVenda extends javax.swing.JFrame { 
    //Armazena a ultima pesquisa
    String ultimaPesquisa = null;
    
    //armmazena globalmente o 
    Integer quantidade;
    //Objeto servico carrinho para incluir produtos no carrinho e voltar lista
    public static ServicoCarrinho servicoCarrinho = new ServicoCarrinho();
    ServicoProduto servicoProduto = new ServicoProduto();
    ServicoVenda servicoVenda = new ServicoVenda();
    ServicoCliente servicoCliente = new ServicoCliente();
    
    //Acumula preco total de venda
    public static double precototal = 0.0;
    
    //Variavel para pegar valor digitado do cpf
    public static String cpf = null;
    
 
    /**
     * Creates new form Venda
     */
    public TelaVenda() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNomeProduto = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCarrinho = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        JTextFieldCPF = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
            JTextFieldCPF = new javax.swing.JFormattedTextField(cpf);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
        jLabel6 = new javax.swing.JLabel();
        jLabelValorTotal = new javax.swing.JLabel();
        jButtonFinalizarVenda = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonAdicionarCarrinho = new javax.swing.JButton();
        jLabelCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Venda");
        jLabel1.setToolTipText("");
        jLabel1.setName("titulo"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Busca de Produto");

        jLabel3.setText("Nome do Produto:");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Título", "Plataforma", "Preço", "Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableProdutos);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Carrinho");

        jTableCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Título", "Plataforma", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableCarrinho);

        jLabel5.setText("CPF do Cliente:");

        jLabel6.setText("Valor total:");

        jLabelValorTotal.setText("<valor>");

        jButtonFinalizarVenda.setText("Efetuar Venda");
        jButtonFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarVendaActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonAdicionarCarrinho.setText("Adicionar ao Carrinho");
        jButtonAdicionarCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarCarrinhoActionPerformed(evt);
            }
        });

        jLabelCliente.setText("<Cliente>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonPesquisar)))
                        .addContainerGap(174, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(252, 252, 252))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValorTotal)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonAdicionarCarrinho))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonFinalizarVenda)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAdicionarCarrinho)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelValorTotal)
                    .addComponent(jLabelCliente))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFinalizarVenda)
                    .addComponent(jButtonVoltar))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarVendaActionPerformed

        try {
            this.efetuarVenda();
        } catch (Exception ex) {
            System.out.println("Algo deu errado na finalização de venda, linha 315");
        }

        
    }//GEN-LAST:event_jButtonFinalizarVendaActionPerformed

    public void efetuarVenda() throws Exception{
        //Cria novo objeto produto para manipulação do carrinho
        Produto produto = new Produto();
        
        //Objeto venda para cadastrar todas as vendas
        Venda venda = new Venda();
      
        //Carrega Produtos do Carrinho
        List<Carrinho> listarCarrinho = ServicoCarrinho.listarCarrinho();
        
       
        
//        ItemVenda itens = new ItemVenda();
//        List<ItemVenda> listaItens = new ArrayList();
        
        
        //Captura data atual e formata
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        date.getTime();
        dateFormat.format(date);
        Cliente cliente = servicoCliente.obterClientePorCpf(JTextFieldCPF.getText());
        
        venda.setCliente(cliente);
        venda.setData(date);    
        venda.setValorTotal(precototal);

        ValidadorVenda.validar(venda);

        //Cadastra um novo objeto venda
        int codigo = servicoVenda.cadastrarVenda(venda);//RETURN GENERATED KEYS
        
            for(int i = 0; i < listarCarrinho.size(); i++){               
                ItemVenda itemVenda = new ItemVenda();
    
                //venda.setCodigo(listarCarrinho.get(i).getCodigo());
                //venda.setQuantidade(listarCarrinho.get(i).getQuantidade());
                
                //Adiciona novo produto na lista de produtos da Venda
                produto = servicoProduto.encontrarProdutoPorCodigo(listarCarrinho.get(i).getCodigo());
                itemVenda.setQuantidade(listarCarrinho.get(i).getQuantidade());
                itemVenda.setProduto(produto);
                

                   try {
                        if(cliente!=null){
                            jLabelCliente.setText("Cliente: " + cliente.getNome() + " " + cliente.getSobrenome());
                            
                        }else{
                            jLabelCliente.setText("Cliente não encontrado!");
                            break;
                        }
                        int qtde;
                        quantidade = Integer.valueOf(jTableCarrinho.getValueAt(i, 4).toString());
                        itemVenda.setVenda(venda);

                        servicoVenda.cadastrarItemVenda(itemVenda, codigo);//NAO TA PEGANDO O ID DO VENDA
                        System.out.println("QUANTIDADE:"+ quantidade+" ID:"+produto.getCodigo());
                        //servicoProduto.atualizaEstoque(produto.getCodigo(), quantidade);//NAO ATUALIZA O ESTOQUE
                        

                    } catch (NullPointerException e) {
                        jLabelCliente.setText("Cliente não encontrado!");
                    } catch(IndexOutOfBoundsException x){
                        jLabelCliente.setText("Cliente não encontrado!");  
                            }
                //}
               
            }
            //inclui itens extraidos do pedido na lista da venda
           // venda.setProduto(listaProdutos);

        
        //Caso tenha chegado até aqui,a venda foi realizada com sucesso
            //Então exibe uma mensagem de sucesso para o usuário
            JOptionPane.showMessageDialog(rootPane, "Venda realizada com sucesso: Cliente - " + venda.getCliente().getNome() + " " + 
                    "- valor - R$ " + venda.getValorTotal() +
                            "\n Data: "+venda.getData(),
                    "Venda Efetuada", JOptionPane.INFORMATION_MESSAGE);
            
//            for(int i = 0; i < venda.getProduto().size(); i++){
//                System.out.println("Produto: " + venda.getProduto().get(i).getTitulo());
//            }
            
            
            for(int i = 0; i < ServicoVenda.listarVenda().size(); i++){
                List<Venda> listaVenda = new ArrayList<Venda>();
                listaVenda = ServicoVenda.listarVenda();
                
                List<Produto> listaProduto = new ArrayList<Produto>();
                //listaProduto = listaVenda.get(0).getProduto();
                
                System.out.println("Tamanho = " + listaProduto.size());
            }
            
            //Apaga serviços utilizados para carregar venda, para que seja possível gerar próxima venda
            ServicoCarrinho.apagarLista();
            //listaProdutos.clear();
            listarCarrinho.clear();
            jLabelCliente.setText("<Cliente>");
            JTextFieldCPF.setText("");
            jLabelValorTotal.setText("<Valor>");
            try {
                refreshListCarrinho();
                refreshListProdutosVenda();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "Falha ao esvaziar listas venda!");
                return;
        } 
        
        
    }
    
    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        this.setVisible(false);
        Menu menu = new Menu();
        menu.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        ultimaPesquisa = jTextFieldNomeProduto.getText();
        
        boolean resultadoPesquisa = false;
        
        try {
            resultadoPesquisa = refreshListProdutosVenda();
            refreshListCarrinho();
            jLabelValorTotal.setText("R$ " + precototal);
        } catch (Exception e) {
            //Exibe mensagens de erro na fonte de dados e para o listener
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Falha ao obter lista", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Exibe mensagem de erro caso a pesquisa não tenha resultados
        if (!resultadoPesquisa) {
            JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou resultados ",
                    "Sem resultados", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonAdicionarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarCarrinhoActionPerformed

            String qtdString;
            //Lista de carrinho.
            Carrinho carrinho = new Carrinho();
            Produto produto;

        try{//lógica para abrir uma mensagem de texto e pedir para digitar a quantidade
            qtdString = JOptionPane.showInputDialog(rootPane,"Digite a quantidade");
            quantidade = Integer.valueOf(qtdString);
            
            if (qtdString==null || quantidade <= 0){
                JOptionPane.showMessageDialog(rootPane,"Por favor, digite a quantidade");
                return;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane,"Por favor, digite um número");
        } 
            
            
        try {
            //Captura a linha selecionada da tabela
            final int row = jTableProdutos.getSelectedRow();
            
            
            //Pega a quantidade digitada pelo usuário para determinado produto
           // quantidade = (Integer) jTableProdutos.getValueAt(row, 5);
                
            //Pega o código do produto da tabela
            Integer codigo = (Integer) jTableProdutos.getValueAt(row, 0);
            
            //Consulta o código do produto e atribui o produto ao objeto produto
            produto = servicoProduto.encontrarProdutoPorCodigo(codigo);
            
            //Verifica se já existe produto na lista
            for(int i = 0; i < ServicoCarrinho.listarCarrinho().size(); i++){
                if(produto.getCodigo().equals(ServicoCarrinho.listarCarrinho().get(i).getCodigo())){
                    ServicoCarrinho.listarCarrinho().get(i).setQuantidade(ServicoCarrinho.listarCarrinho().get(i).getQuantidade() + quantidade);
                    //Atualiza preço total e carrega na tela
                    precototal = atualizaPrecoFinal(servicoCarrinho.listarCarrinho());
                    jLabelValorTotal.setText("R$ " + precototal);
                        
                    //Subtrai o valor do carrinho para o estoque
                    carrinho.setQuantidade(quantidade);
                    produto.setEstoque(produto.getEstoque() - carrinho.getQuantidade());
                    
                    servicoProduto.atualizaEstoque(produto.getCodigo(), produto.getEstoque());
                    
                    refreshListCarrinho();
                    refreshListProdutosVenda();
                    return;
                }
            }
        
            carrinho.setCodigo(produto.getCodigo());
            carrinho.setTitulo(produto.getTitulo());
            carrinho.setPlataforma(produto.getPlataforma());
            carrinho.setPreco(produto.getPreco());
            carrinho.setQuantidade(quantidade);
            
            //Validação da carrinho
            ValidadorCarrinho.validar(carrinho);
            
            if(carrinho.getQuantidade() > produto.getEstoque() || carrinho.getQuantidade() == 0){
                JOptionPane.showMessageDialog(rootPane, "Sem saldo em estoque ou produto zerado, favor verificar!", "Sem Estoque",
                            JOptionPane.ERROR_MESSAGE);
 
            }else{
                //Cadastra um novo produto na lista do carrinho
               ServicoCarrinho.cadastrarProdutonoCarrinho(carrinho);
               
               //Subtrai o valor do carrinho para o estoque
               produto.setEstoque(produto.getEstoque() - carrinho.getQuantidade());
               servicoProduto.atualizaEstoque(produto.getCodigo(), produto.getEstoque());
               
               //Refresh na tabela de carrinho
               refreshListCarrinho();
               
               //Refresh na tabela de Produtos
               refreshListProdutosVenda();
               
               //Atualiza preço total e carrega na tela
               precototal = atualizaPrecoFinal(servicoCarrinho.listarCarrinho());
               jLabelValorTotal.setText("R$ " + precototal);
            }
              
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erro ao incluir produto no carrinho, verifique produto e quantidade!");
        }
    }//GEN-LAST:event_jButtonAdicionarCarrinhoActionPerformed
    

    //Atualiza a lista de Produtos. Pode ser chamado por outras telas
    public boolean refreshListProdutosVenda() throws ProdutoException, Exception {
        Produto produto = new Produto();
        
        List<Produto> resultado = servicoProduto.procurarProduto(ultimaPesquisa);

        //Obtém o elemento representante do conteúdo da tabela na tela
        DefaultTableModel model = (DefaultTableModel) jTableProdutos.getModel();
        //Indica que a tabela deve excluir todos seus elementos
        //Isto limpará a lista, mesmo que a pesquisa não tenha sucesso
        model.setRowCount(0);

        //Verifica se não existiram resultados. Caso afirmativo, encerra a
        //atualização e indica ao elemento acionador o não sucesso da pesquisa
        if (resultado == null || resultado.size() <= 0) {
            return false;
        }

        //Percorre a lista de resultados e os adiciona na tabela
        for (int i = 0; i < resultado.size(); i++) {
            produto = resultado.get(i);
            if (produto != null) {
                Object[] row = new Object[13];
                row[0] = produto.getCodigo();
                row[1] = produto.getTitulo();
                row[2] = produto.getPlataforma();
                row[3] = produto.getPreco();
                row[4] = produto.getEstoque();
                model.addRow(row);
            }
        }

        //Se chegamos até aqui, a pesquisa teve sucesso, então
        //retornamos "true" para o elemento acionante, indicando
        //que não devem ser exibidas mensagens de erro
        return true;
    }
    
    //Atualiza a lista de Produtos. Pode ser chamado por outras telas
    public boolean refreshListCarrinho() throws Exception {

        //Obtém o elemento representante do conteúdo da tabela na tela
        DefaultTableModel model = (DefaultTableModel) jTableCarrinho.getModel();
        //Indica que a tabela deve excluir todos seus elementos
        //Isto limpará a lista, mesmo que a pesquisa não tenha sucesso
        model.setRowCount(0);
        
        List<Carrinho> listaCarrinho = new ServicoCarrinho().listarCarrinho();
        //Verifica se não existiram resultados. Caso afirmativo, encerra a
        //atualização e indica ao elemento acionador o não sucesso da pesquisa
        if (!listaCarrinho.isEmpty()) {
            //Percorre a lista de resultados e os adiciona na tabela
            for (int i = 0; i < ServicoCarrinho.listarCarrinho().size(); i++) {
                Carrinho pro =  listaCarrinho.get(i);
                    if (pro != null) {
                    Object[] row = new Object[13];
                    row[0] = pro.getCodigo();
                    row[1] = pro.getTitulo();
                    row[2] = pro.getPlataforma();
                    row[3] = pro.getPreco();
                    row[4] = pro.getQuantidade();
                    model.addRow(row);
                }
            }
        }

        

        //Se chegamos até aqui, a pesquisa teve sucesso, então
        //retornamos "true" para o elemento acionante, indicando
        //que não devem ser exibidas mensagens de erro
        return true;
    }
    //Método busca preço total da TelaVenda
    public static double atualizaPrecoFinal(List<Carrinho> lista){
        precototal = 0;
        for(int i = 0; i < lista.size(); i++){
            precototal = precototal + (lista.get(i).getPreco() * lista.get(i).getQuantidade());
        }
        
        return precototal;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldCPF;
    private javax.swing.JButton jButtonAdicionarCarrinho;
    private javax.swing.JButton jButtonFinalizarVenda;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableCarrinho;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldNomeProduto;
    // End of variables declaration//GEN-END:variables
}
