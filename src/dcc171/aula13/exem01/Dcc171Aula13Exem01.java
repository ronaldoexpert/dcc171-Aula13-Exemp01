package dcc171.aula13.exem01;


public class Dcc171Aula13Exem01 {

    public static void main(String[] args) throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        Produto p = new Produto();
        
        p.setNome("Produto teste");
        p.setQtd(22);
        dao.criaProduto(p);
    }
    
}
