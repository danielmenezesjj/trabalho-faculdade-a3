package controle;

import modelo.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    public ResultSet autenticacaoUsuario(UsuarioDTO objUsuarioDto) {
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

    public void cadastrarUsuario(UsuarioDTO objUsuarioDto) {
        try {
            String sql = "INSERT INTO usuarios(nome_completo, dt_nascimento, adm, cpf, email, telefone, senha, perfil_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objUsuarioDto.getNome_usuario());

            Date sqlDate = new java.sql.Date(objUsuarioDto.getDt_nascimento_usuario().getTime());

            pstm.setDate(2, sqlDate);
            pstm.setBoolean(3, objUsuarioDto.isAdmin());
            pstm.setString(4, objUsuarioDto.getCpf_usuario());
            pstm.setString(5, objUsuarioDto.getEmail_usuario());
            pstm.setString(6, objUsuarioDto.getTelefone_usuario());
            pstm.setString(7, objUsuarioDto.getSenha_usuario());
            pstm.setInt(8, objUsuarioDto.getPerfil_usuario());

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar usuário!");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
        }
    }

    public void cadastrarUsuarioAluno(UsuarioDTO objUsuarioDto) {
        try {
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

    public ArrayList<UsuarioDTO> listarUsuarios() {
        try {
            String sql = "SELECT * FROM usuarios JOIN perfil ON perfil.id = perfil_id";
            PreparedStatement pstm = conn.prepareStatement(sql);

            ArrayList usuarios = new ArrayList<UsuarioDTO>();
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
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

}
