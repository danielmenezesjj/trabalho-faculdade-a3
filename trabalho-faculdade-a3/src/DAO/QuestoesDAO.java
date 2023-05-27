/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Questao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

public class QuestoesDAO {

    Connection conn = (Connection) new ConexaoDAO().connectDB();

    Questao[] questoes = new Questao[2];
    Random random = new Random();
    int aleatorio = random.nextInt(4);
    
    public Questao[] randomizaQuestoes(){
        for(int i = 0; i < questoes.length; i++){
            questoes[i] = (Questao) buscarQuestoes(aleatorio);
        }
        return questoes;
    }
    
    public void listar(){
        for(Questao questao : questoes){
            System.out.println(questao);
        }
    }

    public ResultSet buscarQuestoes(int id) {
        try {
            String sql = "select * from questoes where id = ? LIMIT ?";

            PreparedStatement pstm = conn.prepareCall(sql);
            pstm.setInt(1, id);
            pstm.setInt(2, questoes.length);
            ResultSet rs = pstm.executeQuery();
            
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "QuestoesDAO: " + erro);
            return null;
        }
    }

}
