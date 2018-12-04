/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formsview;

import conexao.Conexao;
import functions.Funcionalidades;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.DadosUser;
import models.StatusPedido;
import queriesaux.QuerysAux;

/**
 *
 * @author Marcos
 */
public class StatusPedidos extends javax.swing.JFrame {
    private String idLogin,idNome, idPerfil, idEmpregado;

    /**
     * Creates new form StatusPedido
     */
    public StatusPedidos() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagens/ic_status.png")));
        setTitle("Status de Pedido");
        this.txtId.setText(String.valueOf(Principal.idEmpregado));
        this.txtId.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        combStatus = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(150, 228, 255));

        TableStatusReembolso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Status", "Nome", "RG", "CPF", "Cargo", "Resultado", "Mês", "Descrição", "Valor Reembolso"
            }
        ));
        jScrollPane1.setViewportView(TableStatusReembolso);
        if (TableStatusReembolso.getColumnModel().getColumnCount() > 0) {
            TableStatusReembolso.getColumnModel().getColumn(6).setResizable(false);
            TableStatusReembolso.getColumnModel().getColumn(8).setResizable(false);
        }

        TableStatusPref.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Status", "Nome", "RG", "CPF", "Cargo", "Resultado", "Mês", "Despesas", "Valor Prestaçao"
            }
        ));
        jScrollPane2.setViewportView(TableStatusPref);
        if (TableStatusPref.getColumnModel().getColumnCount() > 0) {
            TableStatusPref.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Reembolso:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Prestação de Conta:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel2.setBackground(new java.awt.Color(0, 144, 255));

        combStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Em Elaboração", "Aprovado", "Reprovado" }));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Status dos seus Pedidos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(combStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(297, 297, 297)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int idEmpregado = Integer.parseInt(txtId.getText());
        StatusPedido sp = new StatusPedido();
        sp.setResultado(this.combStatus.getSelectedItem().toString());
        Funcionalidades func = new Funcionalidades();
        func.ConsultaGeralPrest(sp.getResultado(), idEmpregado);
        func.ConsultaGeralReembolso(sp.getResultado(), idEmpregado);
    }//GEN-LAST:event_btnBuscarActionPerformed
    /*public String IdsComboxPrest(String result){
        String sqlSelect = QuerysAux.combBoxPrest;
        //Chamo Conexao
         Conexao conexao;
         
         //Tratar se houve algum erro de Conexao
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return null;
            //Caso tenha retorna null
        }
        try 
            //Prepando Query (PreparedStatement)
            (PreparedStatement ps = 
                    //Incluindo Query
                conexao.getConexao().prepareStatement(sqlSelect);)
        {
            //Setando na Query Where passando o Codigo digitado
            ps.setString(1, result);
            
            ResultSet rs;
            try{
                rs = ps.executeQuery();
                
            while(rs.next()){
                combBoxID.addItem(rs.getString("idEmpregados"));
                }
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            ps.executeQuery();
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
    public String IdsComboxReemb(String result){
        String sqlSelect = QuerysAux.combBoxRemb;
        //Chamo Conexao
         Conexao conexao;
         
         //Tratar se houve algum erro de Conexao
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return null;
            //Caso tenha retorna null
        }
        try 
            //Prepando Query (PreparedStatement)
            (PreparedStatement ps = 
                    //Incluindo Query
                conexao.getConexao().prepareStatement(sqlSelect);)
        {
            //Setando na Query Where passando o Codigo digitado
            ps.setString(1, result);
            
            ResultSet rs;
            try{
                rs = ps.executeQuery();
                
            while(rs.next()){
                combBoxID.addItem(rs.getString("idEmpregados"));
                }
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            ps.executeQuery();
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
*/
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing


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
            java.util.logging.Logger.getLogger(StatusPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatusPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatusPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatusPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StatusPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JTable TableStatusPref = new javax.swing.JTable();
    public static final javax.swing.JTable TableStatusReembolso = new javax.swing.JTable();
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> combStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtId;
    // End of variables declaration//GEN-END:variables

    public void receber(DadosUser user) {
        idLogin = user.getId();
        idNome = user.getLogin();
        this.txtId.setText(user.getPerfil()); 
        idEmpregado = user.getIdUser();
        System.out.println(idNome);
        
    }

    void receber(String[] dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}