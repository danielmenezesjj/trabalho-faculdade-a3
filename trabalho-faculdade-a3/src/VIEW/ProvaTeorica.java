/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import DAO.QuestoesDAO;
import DTO.ProvaTeoricaDTO;
import DTO.Questao;
import java.util.Random;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProvaTeorica extends javax.swing.JFrame {

    ArrayList<Questao> questoes = new ArrayList<Questao>();
    ProvaTeoricaDTO provaDto = new ProvaTeoricaDTO();

    int i = 0;
    int acertos = 0;
    String radioo;

    /**
     * Creates new form ProvaTeorica
     */
    public ProvaTeorica() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        txtPergunta.setRows(5);
        jScrollPane1.setViewportView(txtPergunta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txtResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)))
                .addComponent(txtResposta)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma resposta.");
        } else {
            provaDto.setRespostaAluno(radioo);

            if (i == questoes.size() - 1) {
                btnSalvar.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Prova encerrada.\n\nNota: " + provaDto.getAcertos());
            } else {
                if (provaDto.getRespostaAluno() != null && provaDto.getRespostaAluno().equals(txtResposta.getText())) {
                    acertos++;
                    provaDto.setAcertos(acertos);
                    JOptionPane.showMessageDialog(null, "Acertou!");
                } else {
                    JOptionPane.showMessageDialog(null, "Errou.");
                }

                i++;
                alterarQuestao(i);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void setRadioSelected(String radio){
        radioo = radio;
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
        txtResposta.setVisible(false);
        try {

            QuestoesDAO objQuestoesDao = new QuestoesDAO();
            ResultSet rsObjQuestoesDao = objQuestoesDao.buscarQuestoes(5);

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
    }//GEN-LAST:event_formWindowOpened

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
    private javax.swing.JTextArea txtPergunta;
    private javax.swing.JLabel txtResposta;
    // End of variables declaration//GEN-END:variables
}
