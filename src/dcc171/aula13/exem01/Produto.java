package dcc171.aula13.exem01;

public class Produto {
    String nome;
    Integer qtd;

    public Produto() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.length() < 3) throw new Exception("O nome deve ter mais de 2 letras");
        this.nome = nome;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
    
}
