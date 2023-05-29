package DAO;

import DTO.ProvaTeoricaDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProvaTeoricaDAO {
    Connection conn = (Connection) new ConexaoDAO().connectDB();
    
    public void cadastrarProvaTeorica(ProvaTeoricaDTO provaTeorica) throws SQLException{
        String sql = "INSERT into provas_teorica (aluno_id, data_prova, nota, resultado) values (?, ?, ?, ?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        Date sqlDate = new java.sql.Date(provaTeorica.getData_prova().getTime());
        
        pstm.setInt(1, provaTeorica.getIdAluno());
        pstm.setDate(2, sqlDate);
        pstm.setInt(3, provaTeorica.getAcertos());
        pstm.setString(4, provaTeorica.getResultado());
    }
}
