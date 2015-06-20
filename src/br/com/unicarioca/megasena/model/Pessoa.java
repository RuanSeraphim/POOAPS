package br.com.unicarioca.megasena.model;

public class Pessoa {
    
    private String nome;
    
    private String documento;
    
    public Pessoa(String nome, String documento) {
        this.setNome(nome);
        this.setDocumento(documento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        char[] nome_char = nome.toCharArray();
        if (nome_char.length == 0) {
                System.err.println("Nome vazio!");
                System.exit(1);
        }
        for (char c : nome_char) {
            if (!Character.isAlphabetic(c) && !Character.isWhitespace(c)) {
                System.err.println("Nome com caracteres inválidos: "+nome);
                System.exit(1);
            }
        }
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        char[] documento_char = documento.toCharArray();
        if (documento_char.length < 11) {
                System.err.println("CPF com tamanho inválido: "+documento);
                System.exit(1);
        }
        for (char c : documento_char) {
            if (!Character.isDigit(c)) {
                System.err.println("CPF com caracteres inválidos: "+documento);
                System.exit(1);
            }
        }
        this.documento = documento;
    }
    
}
