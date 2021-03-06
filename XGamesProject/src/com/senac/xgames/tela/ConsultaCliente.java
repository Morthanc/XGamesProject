/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.tela;

import com.senac.xgames.exceptions.ClienteException;
import com.senac.xgames.model.Cliente;
import com.senac.xgames.service.ServicoCliente;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author geoinformacao
 */
public class ConsultaCliente extends javax.swing.JFrame {
    
    //Instancia do Form CadastrarCliente para efetuar alteracoes
    CadastroCliente formAlterar = new CadastroCliente();
    //Variável para verificar que alteração foi solicitada
    public boolean alterar = false;
    
    ServicoCliente servicoCliente = new ServicoCliente();
    
    //Armazena a ultima pesquisa
    String ultimaPesquisa = null;
            
    
    /**
     * Creates new form ConsultaCliente
     */
    public ConsultaCliente() {
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNomeCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jPanel1.setAutoscrolls(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cliente");

        jLabel2.setText("Nome do Cliente:");

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Sexo", "Idade", "Telefone", "Celular", "RG", "CPF", "Endereço", "CEP", "e-mail", "Cidade", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCliente.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTableCliente);

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNomeCliente))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(359, 359, 359)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonExcluir))
                .addGap(62, 62, 62)
                .addComponent(jButtonVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        this.setVisible(false);
        Menu menu = new Menu();
        menu.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        //Determina o valor do resultado da pesquisa
        boolean resultadoPesquisa = false;
        
       
        //Pega valor da pesquisa e atribui a variavel para efetuar busca
        ultimaPesquisa = jTextFieldNomeCliente.getText();

        try {
            //Solicita a atualização da lista com o novo critério
            //de pesquisa (ultimaPesquisa)
            resultadoPesquisa = refreshListClientes();
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
        
       /* //Serve para ajustar tamanho das colunas com texto utilizado.
        for (int column = 0; column < jTableCliente.getColumnCount(); column++){
        
            TableColumn tableColumn = jTableCliente.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();
 
            for (int row = 0; row < jTableCliente.getRowCount(); row++){
            
                TableCellRenderer cellRenderer = jTableCliente.getCellRenderer(row, column);
                Component c = jTableCliente.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + jTableCliente.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
 
            if (preferredWidth >= maxWidth){
            preferredWidth = maxWidth;
            break;
                }
            }
 
            tableColumn.setPreferredWidth( preferredWidth );
        }*/
        
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
  
        //Verifica se há itens selecionados para exclusão.
        //Caso negativo, ignora o comando
        if (jTableCliente.getSelectedRow() >= 0) {
            
            //Obtém a linha do item selecionado
            final int row = jTableCliente.getSelectedRow();
            //Obtém o nome do cliente da linha indicada para exibição
            //de mensagem de confirmação de exclusão utilizando seu nome
            String nome = (String) jTableCliente.getValueAt(row, 6);
            //Mostra o diálogo de confirmação de exclusão
            int resposta = JOptionPane.showConfirmDialog(rootPane,
                "Excluir o cliente de cpf\"" + nome + "\"?",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
            //Se o valor de resposta for "Sim" para a exclusão
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    String cpf = jTableCliente.getValueAt(row, 6).toString();
                    servicoCliente.excluirCliente(cpf);
                    
                    this.refreshListClientes();
                } catch (Exception e) {
                    //Se ocorrer algum erro técnico, mostra-o no console,
                    //mas esconde-o do usuário
                    e.printStackTrace();
                    //Exibe uma mensagem de erro genérica ao usuário
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                            "Falha na Exclusão", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        
        
        try {
            //Obtém a linha selecionada na tabela de resultados
            final int row = jTableCliente.getSelectedRow();
            //Verifica se há linha selecionada na tabela
            if (row >= 0) {
                //Obtém a linha selecionada na tabela
                String cpf = jTableCliente.getValueAt(row, 6).toString();
                
                //Solicita ao serviço a obtenção do cliente a partir do
                //ID selecionado na tabela
                System.out.println("procurando cliente de cpf:"+cpf);
                Cliente cliente = servicoCliente.obterClientePorCpf(cpf);
                
                if (cliente!=null){
                    formAlterar = new CadastroCliente();   
                    formAlterar.populateFields(cliente);


                    formAlterar.invalidate();
                    formAlterar.validate();
                    formAlterar.repaint();
                    formAlterar.setCliente(cliente);    
                    this.dispose();
                    this.setVisible(false);
                    formAlterar.setVisible(true); 
                }else{
                     JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado","Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
                }
                
                
                            
               // formAlterar.toFront();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Não é possível "
                + "exibir os detalhes deste cliente.",
                "Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
        }
        
        alterar = false;
    }//GEN-LAST:event_jButtonAlterarActionPerformed
        
    
//Atualiza a lista de clientes. Pode ser chamado por outras telas
    public boolean refreshListClientes() throws ClienteException, Exception {
        //Realiza a pesquisa de clientes com o último valor de pesquisa
        //para atualizar a lista
        List<Cliente> resultado = servicoCliente.procurarCliente(ultimaPesquisa);
      

        //Obtém o elemento representante do conteúdo da tabela na tela
        DefaultTableModel model = (DefaultTableModel) jTableCliente.getModel();
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
            Cliente cli = resultado.get(i);
            if (cli != null) {
                Object[] row = new Object[13];
                //row[0] = cli.getId();
                row[0] = cli.getNome() + " " + cli.getSobrenome();
                row[1] = cli.getSexo();
                row[2] = cli.getIdade();
                row[3] = cli.getTelefone1();
                row[4] = cli.getTelefone2();
                row[5] = cli.getRg();
                row[6] = cli.getCpf();
                row[7] = cli.getLogradouro() + ", " + cli.getNumero() + " - " + cli.getBairro() + " " + cli.getComplemento();
                row[8] = cli.getCep();
                row[9] = cli.getEmail();
                row[10] = cli.getCidade();
                row[11] = cli.getEstado();
                model.addRow(row);
            }
        }

        //Se chegamos até aqui, a pesquisa teve sucesso, então
        //retornamos "true" para o elemento acionante, indicando
        //que não devem ser exibidas mensagens de erro
        return true;
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
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTextField jTextFieldNomeCliente;
    // End of variables declaration//GEN-END:variables
}
