package visao.aluno;

import controle.PagamentoDAO;
import visao.aluno.servicos.Boleto;
import controle.ServicoDAO;
import modelo.ServicoDTO;

import visao.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.UsuarioDTO;
import visao.aluno.servicos.InterfaceNovaCNH;

public class InterfaceAluno extends javax.swing.JFrame {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date dataAtual = new Date();
    /**
     * Creates new form InterfaceAluno
     */
    public InterfaceAluno() {
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

        txtUsuarioLogado = new javax.swing.JLabel();
        btnSegundavia = new javax.swing.JButton();
        btnEmissao = new javax.swing.JButton();
        btnRenovação = new javax.swing.JButton();
        txtData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtUsuarioLogado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtUsuarioLogado.setText("Olá, #nomeAluno");

        btnSegundavia.setBackground(new java.awt.Color(0, 0, 0));
        btnSegundavia.setForeground(new java.awt.Color(255, 255, 255));
        btnSegundavia.setText("Segunda via CNH");
        btnSegundavia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSegundaviaActionPerformed(evt);
            }
        });

        btnEmissao.setBackground(new java.awt.Color(0, 0, 0));
        btnEmissao.setForeground(new java.awt.Color(255, 255, 255));
        btnEmissao.setText("Emissão de nova CNH");
        btnEmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmissaoActionPerformed(evt);
            }
        });

        btnRenovação.setBackground(new java.awt.Color(0, 0, 0));
        btnRenovação.setForeground(new java.awt.Color(255, 255, 255));
        btnRenovação.setText("Renovação CNH");
        btnRenovação.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenovaçãoActionPerformed(evt);
            }
        });

        txtData.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtData.setText("Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSegundavia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRenovação, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtUsuarioLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuarioLogado)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(btnEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnSegundavia, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnRenovação, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmissaoActionPerformed
        ResultSet rsPgmDAO = new PagamentoDAO().buscar(UsuarioDTO.usuarioLogado.getId_usuario());
        
        try {
            if(rsPgmDAO.next()){ 
                new InterfaceNovaCNH().setVisible(true);
            }else{
                buscarServico(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEmissaoActionPerformed
  
    private void btnRenovaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenovaçãoActionPerformed
        buscarServico(3);
    }//GEN-LAST:event_btnRenovaçãoActionPerformed

    private void btnSegundaviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSegundaviaActionPerformed
        buscarServico(2);
    }//GEN-LAST:event_btnSegundaviaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtUsuarioLogado.setText("Olá, " + UsuarioDTO.usuarioLogado.getNome_usuario());
        
        String data = String.valueOf(sdf.format(dataAtual));
        txtData.setText(data);
    }//GEN-LAST:event_formWindowOpened
    
    private void buscarServico(int id){
    try {
            ServicoDTO objServicoDto = new ServicoDTO();
            objServicoDto.setId(id);

            ServicoDAO objServicoDao = new ServicoDAO();
            ResultSet rsServicoDao = objServicoDao.getServico(objServicoDto);

            if (rsServicoDao.next()) {
                objServicoDto.setValor(rsServicoDao.getDouble("preco_item"));
                objServicoDto.setItem(rsServicoDao.getString("nome_item"));
                
                Boleto objBoleto = new Boleto();
                objBoleto.getServico(objServicoDto);
                objBoleto.setVisible(true);             
            } else {
                JOptionPane.showMessageDialog(null, "Serviço não encontrado.");
            }

            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "InterfaceALuno: " + erro);
        }
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
            java.util.logging.Logger.getLogger(InterfaceAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmissao;
    private javax.swing.JButton btnRenovação;
    private javax.swing.JButton btnSegundavia;
    private javax.swing.JLabel txtData;
    private javax.swing.JLabel txtUsuarioLogado;
    // End of variables declaration//GEN-END:variables
}
