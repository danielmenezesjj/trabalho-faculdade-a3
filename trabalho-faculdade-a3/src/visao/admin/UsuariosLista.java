package visao.admin;

import controle.admin.AdminDAO;
import javax.swing.JOptionPane;
import modelo.UsuarioDTO;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosLista extends javax.swing.JFrame {

    /**
     * Creates new form UsuariosLista
     */
    public UsuariosLista() {
        initComponents();
        listarUsuarios();
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
        jTUsuarios = new javax.swing.JTable();
        excluirUsuario = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Perfil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTUsuarios);

        excluirUsuario.setText("Excluir");
        excluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirUsuario(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(excluirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(excluirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void excluirUsuario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirUsuario
        int rowIndex = jTUsuarios.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para excluir.", "Usuário não selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idUsuario = (int) jTUsuarios.getValueAt(rowIndex, 0);

        AdminDAO usuarioDao = new AdminDAO();
        boolean excluido = usuarioDao.excluirUsuario(idUsuario);
        if (excluido) {
            DefaultTableModel modelo = (DefaultTableModel) jTUsuarios.getModel();
            modelo.removeRow(rowIndex);
            JOptionPane.showMessageDialog(this, "Usuário excluído com sucesso.", "Usuário excluído", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Falha ao excluir o usuário.", "Erro ao excluir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_excluirUsuario

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        int rowIndex = jTUsuarios.getSelectedRow();

        String cpfUsuario = (String) jTUsuarios.getValueAt(rowIndex, 2);

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para editar.", "Usuário não selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ResultSet rsUsuario = new AdminDAO().buscarUsuario(cpfUsuario);

        try {
            if (rsUsuario.next()) {
                UsuarioDTO usuarioDto = new UsuarioDTO();
                java.sql.Date sqlDate = rsUsuario.getDate("dt_nascimento");
                long milliseconds = sqlDate.getTime();
                java.util.Date date = new java.util.Date(milliseconds);
                
                
                usuarioDto.setNome_usuario(rsUsuario.getString("nome_completo"));
                usuarioDto.setCpf_usuario(rsUsuario.getString("cpf"));
                usuarioDto.setEmail_usuario(rsUsuario.getString("email"));
                usuarioDto.setDt_nascimento_usuario(date);
                usuarioDto.setSenha_usuario(rsUsuario.getString("senha"));
                usuarioDto.setTelefone_usuario(rsUsuario.getString("telefone"));
                usuarioDto.setPerfil_usuario(rsUsuario.getInt("perfil_id"));

                new EditarUsuarios(usuarioDto).setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void listarUsuarios() {
        DefaultTableModel modelo = (DefaultTableModel) jTUsuarios.getModel();

        AdminDAO usDao = new AdminDAO();

        for (UsuarioDTO u : usDao.listarUsuarios()) {
            modelo.addRow(new Object[]{
                u.getId_usuario(),
                u.getNome_usuario(),
                u.getCpf_usuario(),
                u.getTipo_perfil()
            });
        }
    }

    private void buscarUsuario() {

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
            java.util.logging.Logger.getLogger(UsuariosLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuariosLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuariosLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuariosLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuariosLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton excluirUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTUsuarios;
    // End of variables declaration//GEN-END:variables
}
