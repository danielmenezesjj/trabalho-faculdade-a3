package controle;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ExameDTO;

public class ExaminadorDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    public ResultSet buscarExame(int idAluno) {
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

    public ArrayList<ExameDTO> listarExamesSemResultado(int tipoExame) throws SQLException {
        try {
            String sql = "SELECT * FROM exames JOIN usuarios ON aluno_id = usuarios.id WHERE tipo_exame_id = ? AND resultado IS NULL";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, tipoExame);
            
            ArrayList exames = new ArrayList<ExameDTO>();

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                ExameDTO exameDto = new ExameDTO();

                exameDto.setId(rs.getInt("id"));
                exameDto.setAluno_nome(rs.getString("usuarios.nome_completo"));
                exameDto.setAluno_cpf(rs.getString("usuarios.cpf"));

                exames.add(exameDto);
            }
            return exames;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ExaminadorDAO: " + e);
            return null;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void lancarResultado(ExameDTO exameDto) {
        try {
            String sql = "UPDATE exames SET resultado = ? WHERE aluno_id = ? AND tipo_exame_id = ";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, exameDto.getResultado());
            pstm.setInt(2, exameDto.getAluno_id());
            pstm.setInt(3, exameDto.getTipo_exame_id());

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Resultado lançado!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar lançar resultado", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ExaminadorDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
