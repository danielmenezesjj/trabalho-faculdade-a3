package visao.admin;

import controle.admin.AdminDAO;
import modelo.UsuarioDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

public class EditarUsuario extends javax.swing.JFrame {

    public EditarUsuario() {
        initComponents();
    }

    public EditarUsuario(UsuarioDTO usuario) {
        initComponents();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dataNascimento = dateFormat.format(usuario.getDt_nascimento_usuario());

        txtNomeCompleto.setText(usuario.getNome_usuario());
        txtCpf.setText(usuario.getCpf_usuario());
        txtDtNascimento.setText(dataNascimento);
        txtSenha.setText(usuario.getSenha_usuario());
        txtEmail.setText(usuario.getEmail_usuario());
        txtTelefone.setText(usuario.getTelefone_usuario());

        switch (usuario.getPerfil_usuario()) {
            case 1:
                rAluno.setSelected(true);
                break;
            case 2:
                rMedico.setSelected(true);
                break;
            case 3:
                rAgente.setSelected(true);
                break;
            case 4:
                rPsicologo.setSelected(true);
                break;
            case 5:
                rAdmin.setSelected(true);
                break;
            default:
                throw new AssertionError();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtNomeCompleto = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        txtTelefone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        rMedico = new javax.swing.JRadioButton();
        rPsicologo = new javax.swing.JRadioButton();
        rAgente = new javax.swing.JRadioButton();
        rAluno = new javax.swing.JRadioButton();
        txtCpf = new javax.swing.JFormattedTextField();
        txtDtNascimento = new javax.swing.JFormattedTextField();
        rAdmin = new javax.swing.JRadioButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        jLabel1.setText("Cadastro");

        txtNomeCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCompletoActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(0, 0, 0));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome Completo");

        jLabel3.setText("CPF");

        jLabel4.setText("E-mail");

        jLabel5.setText("Telefone");

        jLabel6.setText("Senha");

        jLabel7.setText("Data de Nascimento");

        buttonGroup1.add(rMedico);
        rMedico.setText("Médico");

        buttonGroup1.add(rPsicologo);
        rPsicologo.setText("Psicólogo");

        buttonGroup1.add(rAgente);
        rAgente.setText("Agente");

        buttonGroup1.add(rAluno);
        rAluno.setText("Aluno");

        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCpfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });
        txtCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCpfMouseEntered(evt);
            }
        });
        txtCpf.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtCpfCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtCpfInputMethodTextChanged(evt);
            }
        });
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });
        txtCpf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtCpfPropertyChange(evt);
            }
        });
        txtCpf.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                txtCpfVetoableChange(evt);
            }
        });

        txtDtNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDtNascimentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDtNascimentoFocusLost(evt);
            }
        });
        txtDtNascimento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtDtNascimentoPropertyChange(evt);
            }
        });

        buttonGroup1.add(rAdmin);
        rAdmin.setText("Administrador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomeCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtEmail)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rMedico)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(rPsicologo)
                            .addComponent(rAgente)
                            .addComponent(rAluno)
                            .addComponent(txtCpf)
                            .addComponent(rAdmin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rPsicologo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)))
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCompletoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void txtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusLost
    
    }//GEN-LAST:event_txtCpfFocusLost

    private void txtCpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusGained

    }//GEN-LAST:event_txtCpfFocusGained

    private void txtCpfInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtCpfInputMethodTextChanged

    }//GEN-LAST:event_txtCpfInputMethodTextChanged

    private void txtCpfCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtCpfCaretPositionChanged

    }//GEN-LAST:event_txtCpfCaretPositionChanged

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed

    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtDtNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDtNascimentoFocusLost
      

    }//GEN-LAST:event_txtDtNascimentoFocusLost

    private void txtDtNascimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDtNascimentoFocusGained
        
    }//GEN-LAST:event_txtDtNascimentoFocusGained

    private void txtCpfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCpfMouseEntered

    }//GEN-LAST:event_txtCpfMouseEntered

    private void txtCpfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtCpfPropertyChange
         if (txtCpf.getText().isEmpty()) {
            formataCpf();
        }
    }//GEN-LAST:event_txtCpfPropertyChange

    private void txtCpfVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_txtCpfVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfVetoableChange

    private void txtDtNascimentoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtDtNascimentoPropertyChange
        if(txtDtNascimento.getText().isEmpty()){
            formataData();
        }
    }//GEN-LAST:event_txtDtNascimentoPropertyChange

    private void formataCpf() {
        MaskFormatter cpfFormatter;
        try {
            cpfFormatter = new MaskFormatter("###.###.###-##");
            cpfFormatter.install(txtCpf);
            txtCpf.setColumns(10);
        } catch (ParseException ex) {
            Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void formataData() {
        try {
                MaskFormatter dataFormatter = new MaskFormatter("##-##-####");
                dataFormatter.install(txtDtNascimento);
                txtDtNascimento.setColumns(8); // Defina o tamanho do campo conforme necessário
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void limpar() {
        txtNomeCompleto.setText("");
        txtCpf.setText("");
        txtDtNascimento.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        txtSenha.setText("");

        txtNomeCompleto.requestFocus();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton rAdmin;
    private javax.swing.JRadioButton rAgente;
    private javax.swing.JRadioButton rAluno;
    private javax.swing.JRadioButton rMedico;
    private javax.swing.JRadioButton rPsicologo;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDtNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNomeCompleto;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
