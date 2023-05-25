package DAO;

import DTO.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection  conn = (Connection) new ConexaoDAO().connectDB();
    
    public ResultSet autenticacaoUsuario(UsuarioDTO objUsuarioDto){
        try{
            String sql = "SELECT * FROM usuarios JOIN perfil ON usuarios.perfil_id = perfil.id WHERE usuarios.cpf = ? AND usuarios.senha = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUsuarioDto.getCpf_usuario());
            pstm.setString(2, objUsuarioDto.getSenha_usuario());
            ResultSet rs = pstm.executeQuery();
            
            return rs;
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " +erro);
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
    
}
