package controle.aluno;

import controle.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import modelo.PagamentoDTO;

public class PagamentoDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    public void cadastrar(PagamentoDTO pgmtDto) {
        try {
            String sql = "INSERT INTO pagamentos (item_id, aluno_id) values (?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, pgmtDto.getItem_id());
            pstm.setInt(2, pgmtDto.getUsuario_id());

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Pagamento feito!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao fazer pagamento", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "PagamentoDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public ResultSet buscar(int usuario_id) {
        try {
            String sql = "SELECT * FROM pagamentos WHERE aluno_id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, usuario_id);

            ResultSet rs = pstm.executeQuery();

            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "PagamentoDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
