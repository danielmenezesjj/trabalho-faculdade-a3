package controle.detran;

import controle.ConexaoDAO;
import modelo.ServicoDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ServicoDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    public ResultSet getServico(ServicoDTO servico) {
        try {
            String sql = "select * from servicos where id = ?";

            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, servico.getId());
            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ServicoDAO: " + erro);
            return null;
        } 
    }
}
