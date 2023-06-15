package controle.detran;

import java.sql.PreparedStatement;
import controle.ConexaoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.AlunoDTO;

public class ExameDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    public ResultSet buscarExames() {
        String sql = "SELECT * FROM exames WHERE aluno_id = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, AlunoDTO.usuarioLogado.getId_usuario());

            ResultSet rs = pstm.executeQuery();

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, "ExamesDAO: " + ex);
            return null;
        }
    }
    
    
    public ResultSet buscarExamesSemResultado() {
        try {
            String sql = "SELECT * FROM exames WHERE aluno_id = ? AND resultado IS NULL";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, AlunoDTO.usuarioLogado.getId_usuario());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ExameDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } 
    }


    public ResultSet buscarExamesAprovados() {
        String sql = "SELECT * FROM exames WHERE aluno_id = ? AND resultado = 'Aprovado'";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, AlunoDTO.usuarioLogado.getId_usuario());

            ResultSet rs = pstm.executeQuery();

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, "ExamesDAO: " + ex);
            return null;
        }
    }

    public ResultSet buscarExamesReprovados() {
        String sql = "SELECT * FROM exames WHERE aluno_id = ? AND resultado = 'Reprovado'";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, AlunoDTO.usuarioLogado.getId_usuario());

            ResultSet rs = pstm.executeQuery();

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, "ExamesDAO: " + ex);
            return null;
        }
    }
    
        public void deleteExame() {
        try {
            String sql = "DELETE FROM exames WHERE aluno_id = ? AND tipo_exame_id = 3";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, AlunoDTO.usuarioLogado.getId_usuario());

            pstm.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CarteiraDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
