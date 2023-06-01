package visao.aluno.servicos;

import controle.AlunoDAO;
import controle.ExameDAO;
import services.AlunoServices;
import controle.ProvaTeoricaDAO;
import java.awt.Color;
import visao.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.UsuarioDTO;

public class InterfaceNovaCNH extends javax.swing.JFrame {

    AlunoDAO alunoDao = new AlunoDAO();

    /**
     * Creates new form InterfaceNovaCNH
     */
    public InterfaceNovaCNH() {
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

        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtUsuarioLogado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtResultadoMedico = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtResultadoPsicologico = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtResultadoPratico = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        btnMedico = new javax.swing.JButton();
        btnPsicologo = new javax.swing.JButton();
        btnTeorico = new javax.swing.JButton();
        btnPratico = new javax.swing.JButton();

        jButton3.setText("Realizar exame");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Realizar exame");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtUsuarioLogado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtUsuarioLogado.setText("Olá, #nomeAluno");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Etapas");

        jLabel3.setText("Exame Médico");

        txtResultadoMedico.setText("Resultado:");

        jLabel5.setText("Exame Psicológico");

        txtResultadoPsicologico.setText("Resultado:");

        jLabel7.setText("Exame Prático");

        txtResultadoPratico.setText("Resultado:");

        jLabel9.setText("Exame Teórico");

        jLabel10.setText("Resultado:");

        btnImprimir.setBackground(new java.awt.Color(0, 0, 0));
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("Imprimir Carteira");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnMedico.setBackground(new java.awt.Color(51, 102, 255));
        btnMedico.setForeground(new java.awt.Color(255, 255, 255));
        btnMedico.setText("Realizar exame");
        btnMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicoActionPerformed(evt);
            }
        });

        btnPsicologo.setBackground(new java.awt.Color(51, 102, 255));
        btnPsicologo.setForeground(new java.awt.Color(255, 255, 255));
        btnPsicologo.setText("Realizar exame");
        btnPsicologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPsicologoActionPerformed(evt);
            }
        });

        btnTeorico.setBackground(new java.awt.Color(51, 102, 255));
        btnTeorico.setForeground(new java.awt.Color(255, 255, 255));
        btnTeorico.setText("Realizar exame");
        btnTeorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeoricoActionPerformed(evt);
            }
        });

        btnPratico.setBackground(new java.awt.Color(51, 102, 255));
        btnPratico.setForeground(new java.awt.Color(255, 255, 255));
        btnPratico.setText("Realizar exame");
        btnPratico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPraticoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTeorico)
                                    .addComponent(btnPsicologo)
                                    .addComponent(btnPratico)
                                    .addComponent(btnMedico))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtResultadoPsicologico)
                            .addComponent(txtResultadoMedico)
                            .addComponent(jLabel10)
                            .addComponent(txtResultadoPratico)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(txtUsuarioLogado)))
                .addGap(120, 120, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txtUsuarioLogado)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResultadoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMedico))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResultadoPsicologico, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPsicologo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTeorico))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResultadoPratico, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPratico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicoActionPerformed
        // Fazer exame médico
        alunoDao.fazerExame(1);
    }//GEN-LAST:event_btnMedicoActionPerformed

    private void btnPsicologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPsicologoActionPerformed
        // Fazer exame psicológico
        alunoDao.fazerExame(2);
    }//GEN-LAST:event_btnPsicologoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Fazer exame teórico
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnTeoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeoricoActionPerformed
        new ProvaTeorica().setVisible(true);
        

    }//GEN-LAST:event_btnTeoricoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnPraticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPraticoActionPerformed
        // Fazer exame prático
        alunoDao.fazerExame(4);
    }//GEN-LAST:event_btnPraticoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtUsuarioLogado.setText("Olá, " + UsuarioDTO.usuarioLogado.getNome_usuario());
    }//GEN-LAST:event_formWindowOpened

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        buscaExame();
        pegarResultadoProvaTeorica();
        pegarResultadosExames();
    }//GEN-LAST:event_formWindowActivated

    private void buscaExame() {
        try {
            ResultSet rsExDao = new ExameDAO().buscarExame(UsuarioDTO.usuarioLogado.getId_usuario());
            
            while (rsExDao.next()) {   
                int tipo_exame = rsExDao.getInt("tipo_exame_id");
                    if(tipo_exame == 1) btnMedico.setEnabled(false);
                    if(tipo_exame == 2) btnPsicologo.setEnabled(false);
                    if(tipo_exame == 4) btnPratico.setEnabled(false);              
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceNovaCNH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pegarResultadosExames() {
        ResultSet rsExDao = new ExameDAO().buscarExame(UsuarioDTO.usuarioLogado.getId_usuario());

        try {
            if (rsExDao.next()) {
                if (rsExDao.getString("resultado") != null) {
                    txtResultadoMedico.setText(rsExDao.getString("resultado"));
                    txtResultadoPsicologico.setText(rsExDao.getString("resultado"));
                    txtResultadoPratico.setText(rsExDao.getString("resultado"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceNovaCNH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String pegarResultadoProvaTeorica() {

        ProvaTeoricaDAO pDao = new ProvaTeoricaDAO();

        ResultSet rsPDAO = pDao.buscarProva(UsuarioDTO.usuarioLogado.getId_usuario());

        try {
            if (rsPDAO.next()) {
                String resultadoProva = rsPDAO.getString("resultado");
                int notaProva = rsPDAO.getInt("nota");

                jLabel10.setText("Resultado: " + resultadoProva + " - " + (notaProva * 5) + "%");
                jLabel10.setForeground(new Color(0, 102, 0, 255));

                if (resultadoProva.equals("Reprovado")) {
                    jLabel10.setForeground(Color.RED);
                }

                return resultadoProva;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceNovaCNH.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return "";
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
            java.util.logging.Logger.getLogger(InterfaceNovaCNH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceNovaCNH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceNovaCNH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceNovaCNH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceNovaCNH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnMedico;
    private javax.swing.JButton btnPratico;
    private javax.swing.JButton btnPsicologo;
    private javax.swing.JButton btnTeorico;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel txtResultadoMedico;
    private javax.swing.JLabel txtResultadoPratico;
    private javax.swing.JLabel txtResultadoPsicologico;
    private javax.swing.JLabel txtUsuarioLogado;
    // End of variables declaration//GEN-END:variables
}
