package dcc171.aula13.exem01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dcc171Aula13Exem01 {

    public static void main(String[] args) throws Exception {
        
        String driverUrl = "jdbc:derby://localhost:1527/Teste";
        try {
            Connection conexao = DriverManager.getConnection(driverUrl, "usuario", "senha");
            //teste de alteração
            PreparedStatement operacaoInsere = conexao.prepareCall("insert into PRODUTO (nome, qtd, atualizado)"
                    + " values(?,?, current_timestamp)");
            
            Produto p2 = new Produto();
            p2.setNome("Produto A");
            p2.setQtd(22);
            operacaoInsere.clearParameters();
            operacaoInsere.setString(1, p2.getNome());
            operacaoInsere.setInt(2, p2.getQtd());
            operacaoInsere.executeUpdate();
            
            PreparedStatement operacaoListar = conexao.prepareCall(""
                    + "Select nome, qtd from produto where qtd > ?");
            operacaoListar.clearParameters();
            operacaoListar.setInt(1, 0);
            ResultSet resultado = operacaoListar.executeQuery();
            
            while (resultado.next()) {
                Produto p = new Produto();
                p.setNome(resultado.getString(1));
                p.setQtd(resultado.getInt(2));
                System.out.println(p.getNome() + "\t\t" + p.getQtd());
            }
            
                
            
        } catch (SQLException ex) {
            Logger.getLogger(Dcc171Aula13Exem01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
