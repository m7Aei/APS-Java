/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.bean.informacoesCarro;
import models.dao.CarroDAO;

/**
 *
 * @author mateus
 */
public final class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaInformacoes.getModel();
        tabelaInformacoes.setRowSorter(new TableRowSorter(modeloTabela));

        readTabela();
    }

    public void readTabela() {
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaInformacoes.getModel();
        modeloTabela.setNumRows(0);
        CarroDAO infoDAO = new CarroDAO();

        infoDAO.read().forEach((carro) -> {
            modeloTabela.addRow(new Object[]{
                carro.getID_Carro(),
                carro.getDono(),
                carro.getModelo(),
                carro.getPlaca(),
                carro.getCor(),
                carro.getAnoDoCarro(),});
        });
    }

    public void readTabelaForPlaca(String placa) {
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaInformacoes.getModel();
        modeloTabela.setNumRows(0);
        CarroDAO infoDAO = new CarroDAO();

        for (informacoesCarro carro : infoDAO.buscarCarro(placa)) {
            modeloTabela.addRow(new Object[]{
                carro.getID_Carro(),
                carro.getDono(),
                carro.getModelo(),
                carro.getPlaca(),
                carro.getCor(),
                carro.getAnoDoCarro(),});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaInformacoes = new javax.swing.JTable();
        Cadastrar = new javax.swing.JButton();
        Deletar = new javax.swing.JButton();
        textBusca = new javax.swing.JTextField();
        bttBusca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textDono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textModelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textPlaca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textCor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textAno = new javax.swing.JTextField();
        bttAtualizar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        bttMultas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaInformacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Carro", "DONO", "MODELO", "PLACA", "COR", "ANO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaInformacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaInformacoesMouseClicked(evt);
            }
        });
        tabelaInformacoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaInformacoesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaInformacoes);
        if (tabelaInformacoes.getColumnModel().getColumnCount() > 0) {
            tabelaInformacoes.getColumnModel().getColumn(5).setResizable(false);
        }

        Cadastrar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Cadastrar.setText("Cadastrar");
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });

        Deletar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Deletar.setText("Excluir");
        Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarActionPerformed(evt);
            }
        });

        textBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscaActionPerformed(evt);
            }
        });

        bttBusca.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        bttBusca.setText("Buscar");
        bttBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBuscaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Dono:");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Modelo:");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Placa:");

        textPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPlacaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Cor:");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setText("Ano:");

        textAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAnoActionPerformed(evt);
            }
        });

        bttAtualizar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        bttAtualizar.setText("Atualizar");
        bttAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAtualizarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel6.setText("Registro de Veículos");

        bttMultas.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        bttMultas.setText("Registrar Multa");
        bttMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttMultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(textCor, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bttMultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textModelo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textDono, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textAno, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(bttAtualizar)
                                .addGap(18, 18, 18)
                                .addComponent(Deletar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDono, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bttMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        // TODO add your handling code here:
        informacoesCarro carro = new informacoesCarro();
        CarroDAO carroDAO = new CarroDAO();

        carro.setDono(textDono.getText());
        carro.setModelo(textModelo.getText());
        carro.setPlaca(textPlaca.getText());
        carro.setCor(textCor.getText());
        carro.setAnoDoCarro(Integer.parseInt(textAno.getText()));

        carroDAO.create(carro);
        // aq embaixo vc limpa os campos
        textDono.setText("");
        textModelo.setText("");
        textPlaca.setText("");
        textCor.setText("");
        textAno.setText("");

        readTabela();
    }//GEN-LAST:event_CadastrarActionPerformed

    private void tabelaInformacoesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaInformacoesKeyReleased
        // TODO add your handling code here:
        if (tabelaInformacoes.getSelectedRow() != -1) {
            textDono.setText(tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 1).toString());
            textModelo.setText(tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 2).toString());
            textPlaca.setText(tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 3).toString());
            textCor.setText(tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 4).toString());
            textAno.setText(tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_tabelaInformacoesKeyReleased

    private void DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarActionPerformed
        // TODO add your handling code here:
        if (tabelaInformacoes.getSelectedRow() != -1) {
            informacoesCarro carro = new informacoesCarro();
            CarroDAO carroDAO = new CarroDAO();
            
            carro.setID_Carro((int) tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 0));
            
            carroDAO.delete(carro);
            
            textDono.setText("");
            textModelo.setText("");
            textPlaca.setText("");
            textCor.setText("");
            textAno.setText("");

            readTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item para ser excluido");
        }
    }//GEN-LAST:event_DeletarActionPerformed

    private void textBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscaActionPerformed

    private void bttBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBuscaActionPerformed
        // TODO add your handling code here:
        readTabelaForPlaca(textBusca.getText());
    }//GEN-LAST:event_bttBuscaActionPerformed

    private void textPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPlacaActionPerformed

    private void textAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAnoActionPerformed

    private void bttAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAtualizarActionPerformed
        // TODO add your handling code here:
        if (tabelaInformacoes.getSelectedRow() != -1) {
            informacoesCarro carro = new informacoesCarro();
            CarroDAO carroDAO = new CarroDAO();

            carro.setDono(textDono.getText());
            carro.setCor(textCor.getText());
            carro.setID_Carro((int)tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 0));

            carroDAO.update(carro);
            // aq embaixo vc limpa os campos
            textDono.setText("");
            textModelo.setText("");
            textPlaca.setText("");
            textCor.setText("");
            textAno.setText("");

            readTabela();
        }
    }//GEN-LAST:event_bttAtualizarActionPerformed

    private void tabelaInformacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaInformacoesMouseClicked
        // TODO add your handling code here:
        if (tabelaInformacoes.getSelectedRow() != -1) {
            textDono.setText(tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 1).toString());
            textModelo.setText(tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 2).toString());
            textPlaca.setText(tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 3).toString());
            textCor.setText(tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 4).toString());
            textAno.setText(tabelaInformacoes.getValueAt(tabelaInformacoes.getSelectedRow(), 5).toString());        
        }
    }//GEN-LAST:event_tabelaInformacoesMouseClicked

    private void bttMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttMultasActionPerformed
        // TODO add your handling code here:
        new Multas().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bttMultasActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JButton Deletar;
    private javax.swing.JButton bttAtualizar;
    private javax.swing.JButton bttBusca;
    private javax.swing.JButton bttMultas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaInformacoes;
    private javax.swing.JTextField textAno;
    private javax.swing.JTextField textBusca;
    private javax.swing.JTextField textCor;
    private javax.swing.JTextField textDono;
    private javax.swing.JTextField textModelo;
    private javax.swing.JTextField textPlaca;
    // End of variables declaration//GEN-END:variables
}
