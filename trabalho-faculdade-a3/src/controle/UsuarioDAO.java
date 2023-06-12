package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Usuario;
import visao.admin.MainAdmin;
import visao.aluno.MainAluno;
import visao.examinadores.MainExaminador;

public class UsuarioDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    private ResultSet autenticacaoUsuario(Usuario usuario) {
        try {
            String sql = "SELECT * FROM usuarios WHERE usuarios.cpf = ? AND usuarios.senha = ?";

            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, usuario.getCpf_usuario());
            pstm.setString(2, usuario.getSenha_usuario());
            ResultSet rs = pstm.executeQuery();

            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }

    public boolean logar(Usuario usuario) {
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
                        new MainAluno().setVisible(true);
                        break;
                    case 2, 3, 4:
                        new MainExaminador().setVisible(true);
                        break;
                    case 5:
                        new MainAdmin().setVisible(true);
                        break;
                }

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto.");
                return false;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Login: " + erro);

        }
        return false;
    }
}
