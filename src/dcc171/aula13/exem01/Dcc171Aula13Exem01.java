package dcc171.aula13.exem01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dcc171Aula13Exem01 {

    public static void main(String[] args) {
        
        String driverUrl = "jdbc:derby://localhost:1527/Teste";
        try {
            Connection conexao = DriverManager.getConnection(driverUrl, "usuario", "senha");
        } catch (SQLException ex) {
            Logger.getLogger(Dcc171Aula13Exem01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
