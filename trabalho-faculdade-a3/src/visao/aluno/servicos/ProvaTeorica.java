package visao.aluno.servicos;

import controle.detran.ProvaTeoricaDAO;
import controle.detran.QuestaoDAO;
import modelo.ProvaTeoricaDTO;
import modelo.Questao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.UsuarioDTO;

public class ProvaTeorica extends javax.swing.JFrame {

    ArrayList<Questao> questoes = new ArrayList<Questao>();
    ProvaTeoricaDTO provaDto = new ProvaTeoricaDTO();

    int i = 0;
    int acertos = 1;
    String respostaAluno;
    int notaMinima = 14;
    int qtQuestoes = 20;
    Date dataAtual = new Date();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(983, 701));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 622));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Prova Teórica");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(370, 40, 160, 32);

        btnSalvar.setBackground(new java.awt.Color(0, 0, 0));
        btnSalvar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar Resposta");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(380, 610, 170, 40);

        buttonGroup1.add(a);
        a.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        a.setText("a");
        a.setName(""); // NOI18N
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        getContentPane().add(a);
        a.setBounds(70, 390, 110, 30);

        buttonGroup1.add(b);
        b.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        b.setText("b");
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });
        getContentPane().add(b);
        b.setBounds(70, 440, 110, 30);

        buttonGroup1.add(rD);
        rD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rD.setText("d");
        rD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rDActionPerformed(evt);
            }
        });
        getContentPane().add(rD);
        rD.setBounds(70, 540, 110, 30);

        buttonGroup1.add(rC);
        rC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rC.setText("c");
        rC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCActionPerformed(evt);
            }
        });
        getContentPane().add(rC);
        rC.setBounds(70, 490, 110, 30);

        txtResposta.setEnabled(false);
        getContentPane().add(txtResposta);
        txtResposta.setBounds(0, 0, 0, 0);

        txtPergunta.setEditable(false);
        txtPergunta.setBackground(new java.awt.Color(255, 255, 255));
        txtPergunta.setColumns(20);
        txtPergunta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPergunta.setForeground(new java.awt.Color(51, 51, 51));
        txtPergunta.setRows(5);
        jScrollPane1.setViewportView(txtPergunta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 110, 810, 267);

        txtNumQuestao.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtNumQuestao.setText("Questão 1");
        getContentPane().add(txtNumQuestao);
        txtNumQuestao.setBounds(70, 80, 90, 23);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma resposta.");
            return;
        }
        
        provaDto.setRespostaAluno(respostaAluno);
        
        if (i == questoes.size() - 1) {

            // Encerrar a prova
            btnSalvar.setEnabled(false);
            int notaAluno = provaDto.getAcertos();

            provaDto.setAcertos(notaAluno);
            provaDto.setData_prova(dataAtual);
            provaDto.setIdAluno(UsuarioDTO.usuarioLogado.getId_usuario());

            // Lançando resultado
            if (acertos >= notaMinima) {
                provaDto.setResultado("Aprovado");
            } else {
                provaDto.setResultado("Reprovado");
            }

            JOptionPane.showMessageDialog(null, "Prova encerrada.\n\nNota: " + notaAluno + "\n" + provaDto.getResultado());

            // Salvando prova no banco
            new ProvaTeoricaDAO().cadastrarProvaTeorica(provaDto);

            new NovaCNH().setVisible(true);
            this.dispose();

        } else {
            String respostaAluno = provaDto.getRespostaAluno();

            if (provaDto.getRespostaAluno() != null && respostaAluno.equals(txtResposta.getText())) {
                // Incrementa quantidade de acertos caso acerte a resposta
                acertos++;
                provaDto.setAcertos(acertos);
            }

            // Passar para a próxima questão
            i++;
            txtNumQuestao.setText("Questão " + (i + 1));
            alterarQuestao(i);
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

    private void buscarQuestoes() {
        txtResposta.setVisible(false);
        try {

            QuestaoDAO objQuestoesDao = new QuestaoDAO();
            ResultSet rsObjQuestoesDao = objQuestoesDao.buscarQuestoes(qtQuestoes);

            // Armazenando questoes no arrayList
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
