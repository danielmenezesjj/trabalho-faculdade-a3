package controle;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ExameDTO;

public class ExameDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    public void cadastrarExame(ExameDTO exameDto) {
        try {
            String sql = "INSERT INTO exames (tipo_exame_id, aluno_id, resultado) VALUES (?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, exameDto.getTipo_exame_id());
            pstm.setInt(2, exameDto.getAluno_id());
            pstm.setString(3, exameDto.getResultado());
            
            int arrowsAfected = pstm.executeUpdate();
            
            if(arrowsAfected > 0)
                JOptionPane.showMessageDialog(null, "Exame lançado!", "Exame", JOptionPane.PLAIN_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ExameDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }
}
