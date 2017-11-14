package dcc171.aula13.exem01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dcc171Aula13Exem01 {

    public static void main(String[] args) {
        
        String driverUrl = "jdbc:derby://localhost:1527/Teste";
        try {
            Connection conexao = DriverManager.getConnection(driverUrl, "usuario", "senha");
            //teste de alteração
            PreparedStatement operacaoInsere = conexao.prepareCall("insert into PRODUTO (nome, qtd, atualizado)"
                    + " values(?,?, current_timestamp)");
            operacaoInsere.clearParameters();
            operacaoInsere.setString(1, "Bala55");
            operacaoInsere.setInt(2, 102);
            operacaoInsere.executeUpdate();
            
            PreparedStatement operacaoListar = conexao.prepareCall(""
                    + "Select nome, qtd from produto where qtd > ?");
            operacaoListar.clearParameters();
            operacaoListar.setInt(1, 100);
            ResultSet resultado = operacaoListar.executeQuery();
            
            while (resultado.next()) {
                System.out.println(
                        resultado.getString(1) + 
                        "\t\t" + 
                        resultado.getInt(2)
                        );                
            }
            
                
            
        } catch (SQLException ex) {
            Logger.getLogger(Dcc171Aula13Exem01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
