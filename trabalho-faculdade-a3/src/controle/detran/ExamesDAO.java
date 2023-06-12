package controle.detran;

import java.sql.PreparedStatement;
import controle.ConexaoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import modelo.AlunoDTO;

public class ExamesDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    public ResultSet buscarExames() {
        String sql = "SELECT * FROM exames WHERE aluno_id = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, AlunoDTO.usuarioLogado.getId_usuario());

            ResultSet rs = pstm.executeQuery();

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ExamesDAO.class.getName()).log(Level.SEVERE, null, "ExamesDAO: " + ex);
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
            Logger.getLogger(ExamesDAO.class.getName()).log(Level.SEVERE, null, "ExamesDAO: " + ex);
            return null;
        }
    }

    public ResultSet buscarExamesReprovados(int idAluno) {
        String sql = "SELECT * FROM exames WHERE aluno_id = ? AND resultado = 'Reprovado'";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idAluno);

            ResultSet rs = pstm.executeQuery();

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ExamesDAO.class.getName()).log(Level.SEVERE, null, "ExamesDAO: " + ex);
            return null;
        }
    }
}
