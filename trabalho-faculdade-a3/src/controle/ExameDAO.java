package controle;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ExameDTO;

public class ExameDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    
    
    public ResultSet buscarExame(int idAluno){
        try {
            String sql = "SELECT * FROM exames WHERE exames.aluno_id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, idAluno);
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ExameDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
}
