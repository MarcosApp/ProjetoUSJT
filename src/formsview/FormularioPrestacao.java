/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formsview;

import functions.Funcionalidades;
import java.awt.Toolkit;
import javax.naming.Context;
import javax.swing.JOptionPane;
import models.DadosUser;
import models.PrestacaoConta;
import models.StatusPedido;

/**
 *
 * @author Marcos
 */
public final class FormularioPrestacao extends javax.swing.JDialog {
    private String idLogin,idNome, idPerfil, idEmpregado;
    /**
     * Creates new form FomularioPrestacao
     */
    public FormularioPrestacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagens/ic_novo_empregado.png")));
        setTitle("Prestação de Conta");
        this.idPrestaConta.setText(Funcionalidades.IDMaxPrest());
        //this.lblID.setVisible(false);
        //this.idPrestaConta.setVisible(false);
        this.idDP.setText(Funcionalidades.IDMaxDP());
        //this.idDP.setVisible(false);
        this.id.setText(String.valueOf(Principal.idEmpregado));
        this.idChefeEmpregado.setText(String.valueOf(Principal.idChefeEmpregado));
        checkAdiar.setSelected(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        idPrestaConta = new javax.swing.JLabel();
        lblID = new java.awt.Label();
        idDP = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        idChefeEmpregado = new javax.swing.JLabel();
        lblMesRef = new javax.swing.JLabel();
        lbCargoEmpregado = new javax.swing.JLabel();
        lbDataNascimento = new javax.swing.JLabel();
        btnEnviarPedido = new javax.swing.JButton();
        txtMesRef = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        txtPedidoDespesa = new javax.swing.JComboBox<>();
        lblValorPrestacao = new javax.swing.JLabel();
        txtValorPrestacao = new javax.swing.JTextField();
        jSeparatorPrest = new javax.swing.JSeparator();
        CheckNao = new javax.swing.JRadioButton();
        checkSim = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        groupCartao = new javax.swing.JLayeredPane();
        lblCpfEmpregado = new javax.swing.JLabel();
        txtCartaoC = new javax.swing.JFormattedTextField();
        jSeparatorCpf = new javax.swing.JSeparator();
        grupAdiantamento = new javax.swing.JLayeredPane();
        lbServico = new javax.swing.JLabel();
        jSeparatorData = new javax.swing.JSeparator();
        txtAdiantamento = new javax.swing.JTextField();
        checkAdiar = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(150, 228, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTitle.setBackground(new java.awt.Color(0, 144, 255));

        idPrestaConta.setText("idPresta");

        lblID.setText("id");

        idDP.setText("idDP");

        id.setText("id");

        idChefeEmpregado.setText("idChefe");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                        .addGap(0, 781, Short.MAX_VALUE)
                        .addComponent(idPrestaConta))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                        .addComponent(id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idDP)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idChefeEmpregado)
                .addGap(79, 79, 79))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addComponent(idPrestaConta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idDP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(idChefeEmpregado))
        );

        jPanel2.add(panelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 90));

        lblMesRef.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblMesRef.setText("Mês Referencia");
        jPanel2.add(lblMesRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        lbCargoEmpregado.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbCargoEmpregado.setText("Descriçao");
        jPanel2.add(lbCargoEmpregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        lbDataNascimento.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbDataNascimento.setText("Despesa:");
        jPanel2.add(lbDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 170, -1));

        btnEnviarPedido.setBackground(new java.awt.Color(0, 144, 255));
        btnEnviarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_status.png"))); // NOI18N
        btnEnviarPedido.setText("Registrar Conta");
        btnEnviarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarPedidoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEnviarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 220, 70));

        txtMesRef.setBackground(new java.awt.Color(0, 153, 153));
        txtMesRef.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um mês:", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        txtMesRef.setToolTipText("");
        txtMesRef.setBorder(null);
        txtMesRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesRefActionPerformed(evt);
            }
        });
        jPanel2.add(txtMesRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 150, 30));

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescricao);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 220, 120));

        txtPedidoDespesa.setBackground(new java.awt.Color(0, 153, 153));
        txtPedidoDespesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma despesa:", "Refeicao", "Taxi", "Estacionamento", "Brinde", "Passagens", "Hospedagem" }));
        txtPedidoDespesa.setToolTipText("");
        txtPedidoDespesa.setBorder(null);
        txtPedidoDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPedidoDespesaActionPerformed(evt);
            }
        });
        jPanel2.add(txtPedidoDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 160, 30));

        lblValorPrestacao.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblValorPrestacao.setText("Valor da Prestação");
        jPanel2.add(lblValorPrestacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        txtValorPrestacao.setBackground(new java.awt.Color(150, 228, 255));
        txtValorPrestacao.setBorder(null);
        txtValorPrestacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorPrestacaoActionPerformed(evt);
            }
        });
        txtValorPrestacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorPrestacaoKeyTyped(evt);
            }
        });
        jPanel2.add(txtValorPrestacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 190, 20));

        jSeparatorPrest.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparatorPrest, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 190, 10));

        CheckNao.setText("Não");
        CheckNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckNaoActionPerformed(evt);
            }
        });
        jPanel2.add(CheckNao, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        checkSim.setText("Sim");
        checkSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSimActionPerformed(evt);
            }
        });
        jPanel2.add(checkSim, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        jLabel1.setText("Possui Cartão :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, 20));

        lblCpfEmpregado.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblCpfEmpregado.setText("Cartao de Credito:");

        txtCartaoC.setBackground(new java.awt.Color(150, 228, 255));
        txtCartaoC.setBorder(null);
        try {
            txtCartaoC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####.####.####.####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jSeparatorCpf.setBackground(new java.awt.Color(0, 0, 0));

        groupCartao.setLayer(lblCpfEmpregado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        groupCartao.setLayer(txtCartaoC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        groupCartao.setLayer(jSeparatorCpf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout groupCartaoLayout = new javax.swing.GroupLayout(groupCartao);
        groupCartao.setLayout(groupCartaoLayout);
        groupCartaoLayout.setHorizontalGroup(
            groupCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupCartaoLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(groupCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCpfEmpregado)
                    .addComponent(jSeparatorCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCartaoC, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        groupCartaoLayout.setVerticalGroup(
            groupCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupCartaoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblCpfEmpregado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCartaoC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel2.add(groupCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 190, 110));

        lbServico.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbServico.setText("Adiantamento");

        jSeparatorData.setBackground(new java.awt.Color(0, 0, 0));

        txtAdiantamento.setBackground(new java.awt.Color(150, 228, 255));
        txtAdiantamento.setBorder(null);
        txtAdiantamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdiantamentoActionPerformed(evt);
            }
        });
        txtAdiantamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdiantamentoKeyTyped(evt);
            }
        });

        grupAdiantamento.setLayer(lbServico, javax.swing.JLayeredPane.DEFAULT_LAYER);
        grupAdiantamento.setLayer(jSeparatorData, javax.swing.JLayeredPane.DEFAULT_LAYER);
        grupAdiantamento.setLayer(txtAdiantamento, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout grupAdiantamentoLayout = new javax.swing.GroupLayout(grupAdiantamento);
        grupAdiantamento.setLayout(grupAdiantamentoLayout);
        grupAdiantamentoLayout.setHorizontalGroup(
            grupAdiantamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grupAdiantamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grupAdiantamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grupAdiantamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtAdiantamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(jSeparatorData, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(lbServico))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        grupAdiantamentoLayout.setVerticalGroup(
            grupAdiantamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grupAdiantamentoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdiantamento, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorData, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(grupAdiantamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 160, 80));

        checkAdiar.setText("Receber Adiantamento");
        checkAdiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAdiarActionPerformed(evt);
            }
        });
        jPanel2.add(checkAdiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 758, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAdiantamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdiantamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdiantamentoActionPerformed

    private void btnEnviarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarPedidoActionPerformed
        int idEmpregado = Integer.parseInt(id.getText());
        int idChefe = Integer.parseInt(idChefeEmpregado.getText());
        if (txtMesRef.getSelectedIndex() == 0  || txtPedidoDespesa.getSelectedIndex() == 0 || txtDescricao.getText().equals("") || txtValorPrestacao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Por favor, preenchar todas os campos corretamente", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
        
        PrestacaoConta pc = new PrestacaoConta();
        pc.setEmpregadosId(idEmpregado);
        pc.setMesRef(this.txtMesRef.getSelectedItem().toString());
        pc.setCartaoC(this.txtCartaoC.getText());
        pc.setDespesas(this.txtPedidoDespesa.getSelectedItem().toString());
        pc.setDescricao(this.txtDescricao.getText());
        pc.setAdiantamento(this.txtAdiantamento.getText());
        pc.setValorPrest(this.txtValorPrestacao.getText());
       
        Funcionalidades func = new Funcionalidades();
        if (func.cadastrarPrestacao(pc)) {
            JOptionPane.showMessageDialog(this, "Pedido de Prestação Cadastrado", "Informação", JOptionPane.INFORMATION_MESSAGE);
            func.enviaDPP(this.idPrestaConta.getText());
            StatusPedido sp = new StatusPedido();
            sp.setResultado("Em Elaboração");
            sp.setEmpregados_idEmpregados(idEmpregado);
            sp.setChefeImediato_idChefeImediato(idChefe);
            sp.setDepartamentoContasPagar_idDepartamentoContaPagar(Integer.parseInt(idDP.getText()));
            func.enviarStatus(sp);
            this.setVisible(false);
        
        }
        else{
            JOptionPane.showMessageDialog(this, "Ocorreu um Erro", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEnviarPedidoActionPerformed

    private void txtMesRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesRefActionPerformed

    }//GEN-LAST:event_txtMesRefActionPerformed

    private void txtPedidoDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPedidoDespesaActionPerformed
        
    }//GEN-LAST:event_txtPedidoDespesaActionPerformed

    private void txtValorPrestacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorPrestacaoActionPerformed

    }//GEN-LAST:event_txtValorPrestacaoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void checkSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSimActionPerformed
        grupAdiantamento.setVisible(false);
        groupCartao.setVisible(true);
        checkSim.isSelected();
        CheckNao.setSelected(false);
        checkAdiar.setSelected(false);
    }//GEN-LAST:event_checkSimActionPerformed

    private void CheckNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckNaoActionPerformed
        groupCartao.setVisible(false);
        grupAdiantamento.setVisible(true);
        CheckNao.isSelected();
        checkSim.setSelected(false);
        checkAdiar.setSelected(false);

    }//GEN-LAST:event_CheckNaoActionPerformed

    private void checkAdiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAdiarActionPerformed
        CheckNao.setSelected(false);
        checkSim.setSelected(false);
        grupAdiantamento.setVisible(true);
        groupCartao.setVisible(true);
    }//GEN-LAST:event_checkAdiarActionPerformed

    private void txtValorPrestacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorPrestacaoKeyTyped
        int numero = 10;
        if (txtValorPrestacao.getText().length()>= numero) {
            evt.consume();
        }
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
        evt.consume();
        JOptionPane.showMessageDialog(rootPane, "Apenas Números");        
        }
    }//GEN-LAST:event_txtValorPrestacaoKeyTyped

    private void txtDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyTyped
        int numero = 40;
        if (txtDescricao.getText().length()>= numero) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescricaoKeyTyped

    private void txtAdiantamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdiantamentoKeyTyped
        int numero = 10;
        if (txtAdiantamento.getText().length()>= numero) {
            evt.consume();
        }
         String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
        evt.consume();
        JOptionPane.showMessageDialog(rootPane, "Apenas Números");        
        }
    }//GEN-LAST:event_txtAdiantamentoKeyTyped

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
            java.util.logging.Logger.getLogger(FormularioPrestacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioPrestacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioPrestacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPrestacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioPrestacao dialog = new FormularioPrestacao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CheckNao;
    private javax.swing.JButton btnEnviarPedido;
    private javax.swing.JRadioButton checkAdiar;
    private javax.swing.JRadioButton checkSim;
    private javax.swing.JLayeredPane groupCartao;
    private javax.swing.JLayeredPane grupAdiantamento;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idChefeEmpregado;
    private javax.swing.JLabel idDP;
    private javax.swing.JLabel idPrestaConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparatorCpf;
    private javax.swing.JSeparator jSeparatorData;
    private javax.swing.JSeparator jSeparatorPrest;
    private javax.swing.JLabel lbCargoEmpregado;
    private javax.swing.JLabel lbDataNascimento;
    private javax.swing.JLabel lbServico;
    private javax.swing.JLabel lblCpfEmpregado;
    private java.awt.Label lblID;
    private javax.swing.JLabel lblMesRef;
    private javax.swing.JLabel lblValorPrestacao;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTextField txtAdiantamento;
    private javax.swing.JFormattedTextField txtCartaoC;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JComboBox<String> txtMesRef;
    private javax.swing.JComboBox<String> txtPedidoDespesa;
    private javax.swing.JTextField txtValorPrestacao;
    // End of variables declaration//GEN-END:variables

    public void receberdados(DadosUser user) {
        idLogin = user.getId();
        idNome = user.getLogin();
        idPerfil = user.getPerfil(); 
        System.out.println(user.getIdUser());
    }
    
}
