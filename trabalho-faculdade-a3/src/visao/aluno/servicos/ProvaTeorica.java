package visao.aluno.servicos;

import controle.ProvaTeoricaDAO;
import controle.QuestoesDAO;
import modelo.ProvaTeoricaDTO;
import modelo.Questao;
import visao.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ProvaTeorica extends javax.swing.JFrame {

    ArrayList<Questao> questoes = new ArrayList<Questao>();
    ProvaTeoricaDTO provaDto = new ProvaTeoricaDTO();

    int i = 0;
    int acertos = 1;
    String respostaAluno;
    int notaMinima = 14;
    int qtQuestoes = 20;

    /**
     * Creates new form ProvaTeorica
     */
    public ProvaTeorica() {
        initComponents();
        buscarQuestoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        a = new javax.swing.JRadioButton();
        b = new javax.swing.JRadioButton();
        rD = new javax.swing.JRadioButton();
        rC = new javax.swing.JRadioButton();
        txtResposta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPergunta = new javax.swing.JTextArea();
        txtNumQuestao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 650));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Prova Teórica");

        btnSalvar.setBackground(new java.awt.Color(0, 0, 0));
        btnSalvar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar Resposta");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        buttonGroup1.add(a);
        a.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        a.setText("a");
        a.setName(""); // NOI18N
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });

        buttonGroup1.add(b);
        b.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        b.setText("b");
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });

        buttonGroup1.add(rD);
        rD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rD.setText("d");
        rD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rDActionPerformed(evt);
            }
        });

        buttonGroup1.add(rC);
        rC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rC.setText("c");
        rC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCActionPerformed(evt);
            }
        });

        txtResposta.setEnabled(false);

        txtPergunta.setEditable(false);
        txtPergunta.setColumns(20);
        txtPergunta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtPergunta.setRows(5);
        jScrollPane1.setViewportView(txtPergunta);

        txtNumQuestao.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(rC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(rD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtNumQuestao, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))
                    .addComponent(txtNumQuestao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma resposta.");
        } else {
            provaDto.setRespostaAluno(respostaAluno);

            if (i == questoes.size() - 1) {
                btnSalvar.setEnabled(false);
                int notaAluno = provaDto.getAcertos();
                Date dataAtual = new Date();

                provaDto.setAcertos(notaAluno);
                provaDto.setData_prova(dataAtual);
                provaDto.setIdAluno(Login.usuarioLogado.getId_usuario());

                if (acertos >= notaMinima) {
                    provaDto.setResultado("Aprovado");
                } else {
                    provaDto.setResultado("Reprovado");
                }

                JOptionPane.showMessageDialog(null, "Prova encerrada.\n\nNota: " + notaAluno + "\n" + provaDto.getResultado());           
                
                // Salvando prova no banco
                new ProvaTeoricaDAO().cadastrarProvaTeorica(provaDto);
                
                new InterfaceNovaCNH().setVisible(true);
                this.dispose();

            } else {
                String respostaAluno = provaDto.getRespostaAluno();
                
                
                if (provaDto.getRespostaAluno() != null && respostaAluno.equals(txtResposta.getText())) {
                    acertos++;
                    provaDto.setAcertos(acertos);
                }

                i++;
                txtNumQuestao.setText(String.valueOf(i + 1));
                alterarQuestao(i);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void setRadioSelected(String radio) {
        respostaAluno = radio;
    }

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        setRadioSelected("a");
    }//GEN-LAST:event_aActionPerformed

    private void bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActionPerformed
        setRadioSelected("b");
    }//GEN-LAST:event_bActionPerformed

    private void rDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rDActionPerformed
        setRadioSelected("d");
    }//GEN-LAST:event_rDActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      
    }//GEN-LAST:event_formWindowOpened

    private void buscarQuestoes(){
          txtResposta.setVisible(false);
        try {

            QuestoesDAO objQuestoesDao = new QuestoesDAO();
            ResultSet rsObjQuestoesDao = objQuestoesDao.buscarQuestoes(qtQuestoes);

            // Amrazenando questoes no arrayList
            while (rsObjQuestoesDao.next()) {
                Questao questao = new Questao();

                String pergunta = rsObjQuestoesDao.getString("pergunta");
                String resposta = rsObjQuestoesDao.getString("resposta");

                questao.setPergunta(pergunta);
                questao.setResposta(resposta.charAt(0));

                questoes.add(questao);
                alterarQuestao(0);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProvaTeorica: " + erro);
        }
    }
    
    private void rCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCActionPerformed
        setRadioSelected("c");
    }//GEN-LAST:event_rCActionPerformed

    public void alterarQuestao(int indice) {
        String pergunta = questoes.get(indice).getPergunta();
        String resposta = String.valueOf(questoes.get(indice).getResposta());

        txtPergunta.setText(pergunta);
        txtResposta.setText(resposta);
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
            java.util.logging.Logger.getLogger(ProvaTeorica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProvaTeorica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProvaTeorica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProvaTeorica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProvaTeorica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton a;
    private javax.swing.JRadioButton b;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rC;
    private javax.swing.JRadioButton rD;
    private javax.swing.JLabel txtNumQuestao;
    private javax.swing.JTextArea txtPergunta;
    private javax.swing.JLabel txtResposta;
    // End of variables declaration//GEN-END:variables
}
