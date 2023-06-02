package controle;

import modelo.ProvaTeoricaDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ProvaTeoricaDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    public void cadastrarProvaTeorica(ProvaTeoricaDTO provaTeorica) {
        try {
            String sql = "INSERT into provas_teorica (aluno_id, data_prova, nota, resultado) values (?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            Date sqlDate = new java.sql.Date(provaTeorica.getData_prova().getTime());

            pstm.setInt(1, provaTeorica.getIdAluno());
            pstm.setDate(2, sqlDate);
            pstm.setInt(3, provaTeorica.getAcertos());
            pstm.setString(4, provaTeorica.getResultado());

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Prova lançada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar prova teórica!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ProvaTeoricaDAO: " + e);
        } 
    }

    public ResultSet buscarProva(int id) {
        try {
            String sql = "SELECT * FROM provas_teorica WHERE aluno_id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ProvaTeoricaDAO: " + e);
            return null;
        }

    }

}
