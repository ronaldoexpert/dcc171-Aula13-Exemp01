package dcc171.aula13.exem01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
    String driverUrl = "jdbc:derby://localhost:1527/Teste";
    Connection conexao = null;
    
    public void criaProduto(Produto p) throws Exception{     
        try {           
            conexao = DriverManager.getConnection(driverUrl, "usuario", "senha");            
            PreparedStatement operacaoInsere = conexao.prepareCall("insert into PRODUTO (nome, qtd, atualizado)"
                    + " values(?,?, current_timestamp)");
            
            operacaoInsere.clearParameters();
            operacaoInsere.setString(1, p.getNome());
            operacaoInsere.setInt(2, p.getQtd());
            operacaoInsere.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(Dcc171Aula13Exem01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Produto> listaProdutos() throws Exception{
        
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
        
        return null;
    }
            
}
