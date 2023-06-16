package controle.aluno;

import controle.ConexaoDAO;
import controle.UsuarioDAO;
import controle.detran.ExameDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import modelo.AlunoDTO;
import modelo.UsuarioDTO;

public class AlunoDAO {

    Connection conn = new ConexaoDAO().connectDB();

    public boolean cadastrarAluno(AlunoDTO alunoDto) {
        try {
            boolean rsBuscaUsuario = new UsuarioDAO().buscarUsuario(alunoDto.getCpf_usuario());

            // Verifica se já existe usuário com o cpf digitado 
            if (rsBuscaUsuario) {
                JOptionPane.showMessageDialog(null, "Usuário já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String sql = "INSERT INTO usuarios(nome_completo, dt_nascimento, cpf, email, telefone, senha, perfil_id) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            Date sqlDate = new java.sql.Date(alunoDto.getDt_nascimento_usuario().getTime());

            pstm.setString(1, alunoDto.getNome_usuario());
            pstm.setDate(2, sqlDate);
            pstm.setString(3, alunoDto.getCpf_usuario());
            pstm.setString(4, alunoDto.getEmail_usuario());
            pstm.setString(5, alunoDto.getTelefone_usuario());
            pstm.setString(6, alunoDto.getSenha_usuario());
            pstm.setInt(7, 1);

            java.util.Date dataAtual = new java.util.Date();

            long diferenca = dataAtual.getTime() - alunoDto.getDt_nascimento_usuario().getTime();
            // Converte data de nascimento de aluno em anos
            long idadeAluno = TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS) / 365;

            if (idadeAluno < 18) {
                JOptionPane.showMessageDialog(null, "Aluno precisa ser maior de idade.");
                return false;
            }

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Aluno cadastrado!" + "\nNome: " + alunoDto.getNome_usuario());
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar usuário!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AlunoDAO: " + e, "AlunoDAO", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public void fazerExame(int tipo_exame) {
        try {
            String sql = "INSERT INTO exames (tipo_exame_id, aluno_id, resultado) VALUES (?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, tipo_exame);
            pstm.setInt(2, UsuarioDTO.usuarioLogado.getId_usuario());
            pstm.setString(3, null);

            int arrowsAfected = pstm.executeUpdate();

            if (arrowsAfected > 0) {
                JOptionPane.showMessageDialog(null, "Exame marcado!", "Exame", JOptionPane.PLAIN_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ExameDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refazerExame(int tipoExameId) {
        try {
            String sql = "UPDATE exames SET resultado = null WHERE aluno_id = ? AND tipo_exame_id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, AlunoDTO.usuarioLogado.getId_usuario());
            pstm.setInt(2, tipoExameId);

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Exame sendo refeito.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ExameDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet consultarExame() {
        try {
            String sql = "SELECT * FROM exames WHERE aluno_id = ? AND resultado IS NOT NULL";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, AlunoDTO.usuarioLogado.getId_usuario());

            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AlunoDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public ResultSet verificaSeContemCarteira() {
        try {
            String sql = "select * from carteira where aluno_id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, AlunoDTO.usuarioLogado.getId_usuario());

            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AlunoDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void iniciarRenovacao() {
        try {
            String sql = "UPDATE carteira SET dt_emissao = NULL, dt_vencimento = NULL WHERE aluno_id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, AlunoDTO.usuarioLogado.getId_usuario());
            
            // Deleta exame Médico-renovação caso exista para poder fazê-lo novamente
            new ExameDAO().deleteExame();
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CarteiraDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
