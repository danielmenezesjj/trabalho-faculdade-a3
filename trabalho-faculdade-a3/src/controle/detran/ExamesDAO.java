package controle.detran;

import java.sql.PreparedStatement;
import controle.ConexaoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ExamesDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    public ResultSet buscarExames(int idAluno) {
        String sql = "SELECT * FROM exames JOIN tipo_exame ON tipo_exame_id = tipo_exame.id WHERE aluno_id = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idAluno);
            
            ResultSet rs = pstm.executeQuery();
            
            return rs;       
        } catch (SQLException ex) {
            Logger.getLogger(ExamesDAO.class.getName()).log(Level.SEVERE, null,"ExamesDAO: " + ex);
            return null;
        }     
    }
}
