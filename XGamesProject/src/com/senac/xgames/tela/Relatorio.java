/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.xgames.tela;

import com.senac.xgames.dao.RelatorioDAO;
import com.senac.xgames.dto.RelatorioDTO;
import com.senac.xgames.exceptions.VendaException;
import com.senac.xgames.model.Produto;
import com.senac.xgames.model.Venda;
import com.senac.xgames.service.ServicoVenda;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author geoinformacao
 */
public class Relatorio extends javax.swing.JFrame {
        RelatorioDAO relatorioDAO = new RelatorioDAO();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateInicio;
        Date dateFim;
        
        public List<Produto> listaProdutosRel = new ArrayList<Produto>();
    /**
     * Creates new form Relatorio
     */
    public Relatorio() {
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
        jLabelRelatorio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelatorioVendas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDataInicio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDataFim = new javax.swing.JTextField();
        jButtonGerarRelatorio = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelRelatorio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelRelatorio.setText("Relatório de Vendas");

        jTableRelatorioVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código Venda", "Cliente", "CPF", "Código Produto", "Nome Produto", "Preço Unitário", "Data Venda", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableRelatorioVendas);

        jLabel1.setText("Data Início:");

        jTextFieldDataInicio.setText("dd/MM/aaaa");
        jTextFieldDataInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDataInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDataInicioFocusLost(evt);
            }
        });
        jTextFieldDataInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldDataInicioMouseClicked(evt);
            }
        });
        jTextFieldDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataInicioActionPerformed(evt);
            }
        });

        jLabel2.setText("Data Fim:");

        jTextFieldDataFim.setText("dd/MM/aaaa");
        jTextFieldDataFim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDataFimFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDataFimFocusLost(evt);
            }
        });
        jTextFieldDataFim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldDataFimMouseClicked(evt);
            }
        });
        jTextFieldDataFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataFimActionPerformed(evt);
            }
        });

        jButtonGerarRelatorio.setText("Gerar Relatório");
        jButtonGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarRelatorioActionPerformed(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelRelatorio)
                .addGap(238, 238, 238))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGerarRelatorio)
                    .addComponent(jButton1))
                .addGap(92, 92, 92))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDataFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataFimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataFimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Menu menu = new Menu();
        menu.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarRelatorioActionPerformed
        int maior30 = 0;
        //date.getTime();
        try{
            dateInicio = dateFormat.parse(jTextFieldDataInicio.getText());
            dateFim = dateFormat.parse(jTextFieldDataFim.getText());

            if(dateInicio.after(dateFim)){
                JOptionPane.showMessageDialog(null, "Data início não pode ser maior que data fim!");
            }
            
        }catch(ParseException e){
            JOptionPane.showMessageDialog(null, e + "O formato da Data deve ser dd/mm/yyyy (01/12/1999)!");
        }
        
        try {
           maior30 = (int) (((dateFim.getTime() - dateInicio.getTime()) + 3600000L) / 86400000L);

           if(maior30 > 30){
               JOptionPane.showMessageDialog(null, "Não é possível buscar periodo maior que 30 dias!");
               return;
           }
           
           
           //maior30 = dateInicio.compareTo(dateFim);
           System.out.println("Diferença entre datas = " + maior30);
           List<RelatorioDTO> relatorios = relatorioDAO.gerarRelatorio(dateInicio, dateFim);
           refreshListProdutosVenda(relatorios);
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Falha ao imprimir relatório!");
                return;
        }

        
    }//GEN-LAST:event_jButtonGerarRelatorioActionPerformed

    private void jTextFieldDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataInicioActionPerformed

    private void jTextFieldDataFimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldDataFimMouseClicked
      
    }//GEN-LAST:event_jTextFieldDataFimMouseClicked

    private void jTextFieldDataInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldDataInicioMouseClicked
       
    }//GEN-LAST:event_jTextFieldDataInicioMouseClicked

    private void jTextFieldDataFimFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataFimFocusGained
    
    }//GEN-LAST:event_jTextFieldDataFimFocusGained

    private void jTextFieldDataFimFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataFimFocusLost

    }//GEN-LAST:event_jTextFieldDataFimFocusLost

    private void jTextFieldDataInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataInicioFocusGained
       
    }//GEN-LAST:event_jTextFieldDataInicioFocusGained

    private void jTextFieldDataInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataInicioFocusLost
    // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataInicioFocusLost
//Atualiza a lista de Produtos. Pode ser chamado por outras telas
   public boolean refreshListProdutosVenda(List<RelatorioDTO> listaRelatorio) throws VendaException, Exception {

        DefaultTableModel model = (DefaultTableModel) jTableRelatorioVendas.getModel();
        //Indica que a tabela deve excluir todos seus elementos
        //Isto limpará a lista, mesmo que a pesquisa não tenha sucesso
        model.setRowCount(0);

        //Verifica se não existiram resultados. Caso afirmativo, encerra a
        //atualização e indica ao elemento acionador o não sucesso da pesquisa
        if (listaRelatorio.isEmpty() || listaRelatorio.get(0)==null) {
            return false;
        }

//        //Percorre a lista de resultados e os adiciona na tabela
            for(int i = 0; i < listaRelatorio.size();i++){  
                RelatorioDTO relatorioDTO = listaRelatorio.get(i);
                System.out.println("inicio: "+dateFormat.format(dateInicio)+"\nFim"+dateFormat.format(dateFim));
                if(dateInicio.before(relatorioDTO.getData()) && dateFim.after(relatorioDTO.getData()) || dateFim.equals(relatorioDTO.getData())){
                    Object[] row = new Object[13];
                    row[0] = relatorioDTO.getCodigoVenda();
                    row[1] = relatorioDTO.getNome();
                    row[2] = relatorioDTO.getCpf();
                    row[3] = relatorioDTO.getCodigoProduto();
                    row[4] = relatorioDTO.getTitulo();
                    row[5] = "R$ " + String.valueOf(relatorioDTO.getPreco());
                    row[6] = dateFormat.format(relatorioDTO.getData());
                    row[7] = "R$ " + String.valueOf(relatorioDTO.getValorTotal());
                    
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
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonGerarRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelRelatorio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelatorioVendas;
    private javax.swing.JTextField jTextFieldDataFim;
    private javax.swing.JTextField jTextFieldDataInicio;
    // End of variables declaration//GEN-END:variables
}
