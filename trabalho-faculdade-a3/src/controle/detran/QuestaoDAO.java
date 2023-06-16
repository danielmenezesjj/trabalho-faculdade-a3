
package controle.detran;

import controle.ConexaoDAO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QuestaoDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    // Retorna questões do banco em ordem aleatória com limite passado no parâmetro
    public ResultSet buscarQuestoes(int limite) {
        try {
            String sql = "select * from questoes ORDER BY RAND() LIMIT ?";

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, limite);

            ResultSet rs = pstm.executeQuery();

            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "QuestoesDAO: " + erro);
            return null;
        } 
    }

}
