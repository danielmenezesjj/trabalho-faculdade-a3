package visao.aluno.servicos;

import controle.aluno.AlunoDAO;
import controle.detran.CarteiraDAO;
import controle.detran.ExamesDAO;
import controle.examinador.ExaminadorDAO;
import controle.detran.ProvaTeoricaDAO;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.AlunoDTO;
import modelo.CarteiraDTO;
import modelo.UsuarioDTO;

public class InterfaceNovaCNH extends javax.swing.JFrame {

    boolean exameMedAprovado = false;
    boolean examePsiAprovado = false;
    boolean examePratAprovado = false;
    boolean provaTeoriAprovado = false;
    boolean chance = false;
    AlunoDAO alunoDao = new AlunoDAO();

    int alunoLogadoId = UsuarioDTO.usuarioLogado.getId_usuario();

    /**
     * Creates new form InterfaceNovaCNH
     */
    public InterfaceNovaCNH() {
        initComponents();

        ativarBotaoSolicitarCarteira();

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
        btnSolicitarCarteira = new javax.swing.JButton();
        btnMedico = new javax.swing.JButton();
        btnPsicologo = new javax.swing.JButton();
        btnTeorico = new javax.swing.JButton();
        btnPratico = new javax.swing.JButton();
        btnImprimirCarteira = new javax.swing.JButton();

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

        btnSolicitarCarteira.setBackground(new java.awt.Color(0, 0, 0));
        btnSolicitarCarteira.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSolicitarCarteira.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitarCarteira.setText("Solicitar Carteira");
        btnSolicitarCarteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarCarteiraActionPerformed(evt);
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

        btnImprimirCarteira.setBackground(new java.awt.Color(0, 0, 0));
        btnImprimirCarteira.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnImprimirCarteira.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimirCarteira.setText("Imprimir Carteira");
        btnImprimirCarteira.setEnabled(false);
        btnImprimirCarteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirCarteiraActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtResultadoPsicologico)
                            .addComponent(txtResultadoMedico)
                            .addComponent(jLabel10)
                            .addComponent(txtResultadoPratico))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(txtUsuarioLogado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnSolicitarCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnImprimirCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImprimirCarteira, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSolicitarCarteira, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(38, 38, 38))
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

    private void btnSolicitarCarteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarCarteiraActionPerformed
        cadastrarCarteira();
    }//GEN-LAST:event_btnSolicitarCarteiraActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        verficaSeJatemCarteira();
        verificaSeJaFezExames();
        pegarResultadoProvaTeorica();
        pegarResultadosExames();
        verificaResultados();

        obterQuantidadeReprovacao();
        verificaSeJaFezProva();
        verificarChance();
        try {
            habilitarChance();
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceNovaCNH.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_formWindowActivated

    private void btnImprimirCarteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirCarteiraActionPerformed
        new Carteira().setVisible(true);
    }//GEN-LAST:event_btnImprimirCarteiraActionPerformed

    private void verificaSeJaFezProva() {
        try {
            // validar se já existe prova com id de usuario
            ProvaTeoricaDAO provaDao = new ProvaTeoricaDAO();
            ResultSet rsPDao = provaDao.buscarProva(alunoLogadoId);

            if (rsPDao.next()) {
                btnTeorico.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceNovaCNH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verificaSeJaFezExames() {
        try {
            ResultSet rsExDao = new ExaminadorDAO().buscarExameSendoFeito(alunoLogadoId);

            while (rsExDao.next()) {
                int tipo_exame = rsExDao.getInt("tipo_exame_id");
                if (tipo_exame == 1) {
                    btnMedico.setEnabled(false);
                }
                if (tipo_exame == 2) {
                    btnPsicologo.setEnabled(false);
                }
                if (tipo_exame == 4) {
                    btnPratico.setEnabled(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceNovaCNH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pegarResultadosExames() {
        ResultSet rsAlunoDao = alunoDao.consultarExame();

        try {
            while (rsAlunoDao.next()) {
                if (rsAlunoDao.getInt("tipo_exame_id") == 1) {
                    txtResultadoMedico.setText("Resultado: " + rsAlunoDao.getString("resultado"));
                }
                if (rsAlunoDao.getInt("tipo_exame_id") == 2) {
                    txtResultadoPsicologico.setText("Resultado: " + rsAlunoDao.getString("resultado"));
                }
                if (rsAlunoDao.getInt("tipo_exame_id") == 4) {
                    txtResultadoPratico.setText("Resultado: " + rsAlunoDao.getString("resultado"));
                }

            }

            rsAlunoDao.close();
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceNovaCNH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String pegarResultadoProvaTeorica() {

        ProvaTeoricaDAO pDao = new ProvaTeoricaDAO();

        ResultSet rsPDAO = pDao.buscarProva(alunoLogadoId);

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

    // Cadastrar carteira 
    private void cadastrarCarteira() {
        Date dataAtual = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataAtual);

        calendar.add(Calendar.YEAR, 4);

        Date dataVencimento = calendar.getTime();

        if (verificaResultados()) {
            CarteiraDTO carteiraDto = new CarteiraDTO();

            carteiraDto.setAluno_nome(AlunoDTO.usuarioLogado.getNome_usuario());
            carteiraDto.setDt_emissao(dataAtual);
            carteiraDto.setDt_vencimento(dataVencimento);
            carteiraDto.setAluno_id(alunoLogadoId);
            carteiraDto.setAluno_cpf(AlunoDTO.usuarioLogado.getCpf_usuario());

            JOptionPane.showMessageDialog(null, "Solicitação feita!");

            new CarteiraDAO().cadastrarCarteira(carteiraDto);

        }
    }

    private boolean verificaResultados() {

        ResultSet rsProvaDao = new ProvaTeoricaDAO().buscarProva(alunoLogadoId);
        ResultSet rsExDao = new ExamesDAO().buscarExames(alunoLogadoId);

        try {
            if (!rsExDao.next()) {
                return false;
            }
            while (rsExDao.next()) {
                String resultado = rsExDao.getString("resultado");
                int tipoExameId = rsExDao.getInt("tipo_exame_id");

                if ("Aprovado".equals(resultado) && tipoExameId == 1) {
                    btnMedico.setEnabled(false);
                    exameMedAprovado = true;
                }

                if ("Aprovado".equals(resultado) && tipoExameId == 2) {
                    btnPsicologo.setEnabled(false);
                    examePsiAprovado = true;
                }

                if ("Aprovado".equals(resultado) && tipoExameId == 4) {
                    btnPratico.setEnabled(false);
                    examePratAprovado = true;
                }
            }

            while (rsProvaDao.next()) {
                String resultado = rsProvaDao.getString("resultado");

                if ("Aprovado".equals(resultado)) {
                    provaTeoriAprovado = true;
                }
            }

            if (exameMedAprovado && examePratAprovado && examePsiAprovado && provaTeoriAprovado) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            Logger.getLogger(InterfaceNovaCNH.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    private void ativarBotaoSolicitarCarteira() {
        if (verificaResultados()) {
            btnSolicitarCarteira.setEnabled(true);
        } else {
            btnSolicitarCarteira.setEnabled(false);
        }
    }

    private void verficaSeJatemCarteira() {
        try {
            ResultSet rsCarteira = new CarteiraDAO().buscaCarteira(alunoLogadoId);

            if (rsCarteira.next()) {
                btnSolicitarCarteira.setEnabled(false);
                btnImprimirCarteira.setEnabled(true);
            }

        } catch (SQLException e) {
        }
    }

    private void habilitarChance() throws SQLException {
        if (chance) {
            ResultSet rsExames = new ExamesDAO().buscarExames(alunoLogadoId);
            if (rsExames.next() && rsExames.getString("resultado").equals("Reprovado")) {
                JOptionPane.showMessageDialog(null, "Você tem mais uma chance para fazer o " + rsExames.getString("tipo_exame.nome"));

                switch (rsExames.getInt("tipo_exame_id")) {
                    case 1:
                        btnMedico.setEnabled(true);
                        break;
                    case 2:
                        btnPsicologo.setEnabled(true);
                        break;
                    case 4:
                        btnPratico.setEnabled(true);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void verificarChance() {
        int contadorReprovacao = obterQuantidadeReprovacao();
        chance = contadorReprovacao == 1;
    }

    private int obterQuantidadeReprovacao() {
        int contadorReprovacao = 0;
        try {
            ResultSet rsExames = new ExamesDAO().buscarExames(alunoLogadoId);

            while (rsExames.next()) {
                contadorReprovacao++;
            }
        } catch (SQLException e) {
        }
        return contadorReprovacao;
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
    private javax.swing.JButton btnImprimirCarteira;
    private javax.swing.JButton btnMedico;
    private javax.swing.JButton btnPratico;
    private javax.swing.JButton btnPsicologo;
    private javax.swing.JButton btnSolicitarCarteira;
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
