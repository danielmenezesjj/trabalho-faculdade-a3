package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.UsuarioDTO;

public class AlunoDAO {

    Connection conn = new ConexaoDAO().connectDB();
    
    public boolean buscarUsuario(String cpf) {
        try {
            String sql = "SELECT * FROM usuarios WHERE usuarios.cpf = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cpf);

            ResultSet rs = pstm.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuário." + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void cadastrarUsuarioAluno(UsuarioDTO objUsuarioDto) {
        try {

            boolean rsBuscaUsuario = buscarUsuario(objUsuarioDto.getCpf_usuario());

            if (rsBuscaUsuario) {
                JOptionPane.showMessageDialog(null, "Usuário já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "INSERT INTO usuarios(nome_completo, dt_nascimento, adm, cpf, email, telefone, senha, perfil_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objUsuarioDto.getNome_usuario());

            Date sqlDate = new java.sql.Date(objUsuarioDto.getDt_nascimento_usuario().getTime());

            pstm.setDate(2, sqlDate);
            pstm.setBoolean(3, false);
            pstm.setString(4, objUsuarioDto.getCpf_usuario());
            pstm.setString(5, objUsuarioDto.getEmail_usuario());
            pstm.setString(6, objUsuarioDto.getTelefone_usuario());
            pstm.setString(7, objUsuarioDto.getSenha_usuario());
            pstm.setInt(8, 1);

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Aluno cadastrado!" + "\nNome: " + objUsuarioDto.getNome_usuario());
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar usuário!");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
        }
    }
}
