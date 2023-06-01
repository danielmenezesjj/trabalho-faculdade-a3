package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.UsuarioDTO;
import visao.admin.PrincipalAdmin;
import visao.aluno.InterfaceAluno;
import visao.examinadores.InterfaceExaminador;

public class UsuarioDAO {
    Connection conn = (Connection) new ConexaoDAO().connectDB();
    
       private ResultSet autenticacaoUsuario(UsuarioDTO objUsuarioDto) {
        try {
            String sql = "SELECT * FROM usuarios WHERE usuarios.cpf = ? AND usuarios.senha = ?";

            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objUsuarioDto.getCpf_usuario());
            pstm.setString(2, objUsuarioDto.getSenha_usuario());
            ResultSet rs = pstm.executeQuery();

            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }
    
    public void logar(UsuarioDTO usuario) {
        try {         
            // Autenticação
            ResultSet rs = autenticacaoUsuario(usuario);

            if (rs.next()) {
                // Verifanco tipo de perfil            
                usuario.setNome_usuario(rs.getString("nome_completo"));
                usuario.setId_usuario(rs.getInt("id"));
                usuario.setPerfil_usuario(rs.getInt("perfil_id"));
                usuario.usuarioLogado = usuario;
                
                switch (rs.getInt("perfil_id")) {
                    case 1:
                        new InterfaceAluno().setVisible(true);
                        break;
                    case 2:
                        new InterfaceExaminador().setVisible(true);
                        break;

                    case 3:
                        new InterfaceExaminador().setVisible(true);
                        break;

                    case 4:
                        new InterfaceExaminador().setVisible(true);
                        break;
                    case 5:
                        new PrincipalAdmin().setVisible(true);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto.");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Login: " + erro);

        }
    }
}
