package controle.admin;

import controle.ConexaoDAO;
import controle.UsuarioDAO;
import controle.examinador.ExaminadorDAO;
import modelo.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AdminDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    public boolean cadastrarUsuario(UsuarioDTO objUsuarioDto) {

        try {

            boolean rsBuscaUsuario = new UsuarioDAO().buscarUsuario(objUsuarioDto.getCpf_usuario());

            // Verifica se já existe usuário com o cpf digitado 
            if (rsBuscaUsuario) {
                JOptionPane.showMessageDialog(null, "Usuário já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String sql = "INSERT INTO usuarios(nome_completo, dt_nascimento, cpf, email, telefone, senha, perfil_id) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            Date sqlDate = new java.sql.Date(objUsuarioDto.getDt_nascimento_usuario().getTime());

            pstm.setString(1, objUsuarioDto.getNome_usuario());
            pstm.setDate(2, sqlDate);
            pstm.setString(3, objUsuarioDto.getCpf_usuario());
            pstm.setString(4, objUsuarioDto.getEmail_usuario());
            pstm.setString(5, objUsuarioDto.getTelefone_usuario());
            pstm.setString(6, objUsuarioDto.getSenha_usuario());
            pstm.setInt(7, objUsuarioDto.getPerfil_usuario());

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar usuário!");
                return false;
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return false;
        }

    }

    public boolean excluirUsuario(int idUsuario) {
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idUsuario);

            int rowsAffected = pstm.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ExaminadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<UsuarioDTO> listarUsuarios() {
        try {
            String sql = "SELECT * FROM usuarios JOIN perfil ON perfil.id = perfil_id";
            PreparedStatement pstm = conn.prepareStatement(sql);

            ArrayList usuarios = new ArrayList<UsuarioDTO>();

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                UsuarioDTO usuarioDto = new UsuarioDTO();
                usuarioDto.setId_usuario(rs.getInt("id"));
                usuarioDto.setNome_usuario(rs.getString("nome_completo"));
                usuarioDto.setCpf_usuario(rs.getString("cpf"));
                usuarioDto.setPerfil_usuario(rs.getInt("perfil_id"));
                usuarioDto.setTipo_perfil(rs.getString("nome_perfil"));

                usuarios.add(usuarioDto);
            }

            return usuarios;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }

    public void editarUsuario(UsuarioDTO usuario) {
        try {
            String sql = "UPDATE usuarios"
                    + " SET nome_completo = ?, "
                    + "dt_nascimento = ?, "
                    + "cpf = ?, "
                    + "email = ?, "
                    + "telefone = ?, "
                    + "senha = ?, "
                    + "perfil_id = ? "
                    + "WHERE id = ?";

            PreparedStatement pstm = conn.prepareStatement(sql);

            Date sqlDate = new java.sql.Date(usuario.getDt_nascimento_usuario().getTime());

            pstm.setString(1, usuario.getNome_usuario());
            pstm.setDate(2, sqlDate);
            pstm.setString(3, usuario.getCpf_usuario());
            pstm.setString(4, usuario.getEmail_usuario());
            pstm.setString(5, usuario.getTelefone_usuario());
            pstm.setString(6, usuario.getSenha_usuario());
            pstm.setInt(7, usuario.getPerfil_usuario());
            pstm.setInt(8, usuario.getId_usuario());

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao alterar usuário.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + e);
        }

    }

    public ResultSet buscarUsuario(String cpf) {
        try {
            String sql = "SELECT * FROM usuarios WHERE usuarios.cpf = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cpf);

            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuário." + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
