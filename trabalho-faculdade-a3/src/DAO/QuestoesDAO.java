/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Questao;
import DTO.Usuario;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

public class QuestoesDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

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
