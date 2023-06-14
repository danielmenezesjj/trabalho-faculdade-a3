package controle.detran;

import controle.ConexaoDAO;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.AlunoDTO;
import modelo.CarteiraDTO;

public class CarteiraDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    public void cadastrarCarteira(CarteiraDTO carteira) {
        try {
            String sql = "INSERT INTO carteira (dt_emissao, dt_vencimento, aluno_id) values (?,?,?)";

            PreparedStatement pstm = conn.prepareStatement(sql);
            Date sqlDateDt_emissao = new java.sql.Date(carteira.getDt_emissao().getTime());
            Date sqlDateDt_vencimento = new java.sql.Date(carteira.getDt_vencimento().getTime());

            pstm.setDate(1, sqlDateDt_emissao);
            pstm.setDate(2, sqlDateDt_vencimento);
            pstm.setInt(3, carteira.getAluno_id());

            int rowsAffect = pstm.executeUpdate();

            if (rowsAffect > 0) {
                JOptionPane.showMessageDialog(null, "Carteira disponível para imprimir!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CarteiraDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet buscaCarteira() {
        try {
            String sql = "SELECT * FROM carteira JOIN usuarios ON aluno_id = usuarios.id WHERE aluno_id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, AlunoDTO.usuarioLogado.getId_usuario());

            ResultSet rs = pstm.executeQuery();

            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CarteiraDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void renovarCarteira(CarteiraDTO carteira){
        try {
            String sql = "UPDATE carteira SET dt_emissao = ?, dt_vencimento = ? WHERE aluno_id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            Date sqlDateDt_emissao = new java.sql.Date(carteira.getDt_emissao().getTime());
            Date sqlDateDt_vencimento = new java.sql.Date(carteira.getDt_vencimento().getTime());

            pstm.setDate(1, sqlDateDt_emissao);
            pstm.setDate(2, sqlDateDt_vencimento);
            pstm.setInt(3, AlunoDTO.usuarioLogado.getId_usuario());

            pstm.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CarteiraDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
