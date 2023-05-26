package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO{
    public static void main(String[] args) throws Exception {
        
    }
        public  Connection connectDB(){
        Connection conn = null;
        
        try{
            String url = "jdbc:mysql://localhost:3306/detran?user=root&password=root";
            conn = DriverManager.getConnection(url);

            System.out.println("DB connected!");
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro);
        }
        return conn;
        }
        
    
}
