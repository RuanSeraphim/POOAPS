package br.com.unicarioca.megasena.controller;

import java.io.*;

public abstract class Leitor {
    
    protected FileReader arquivo;
    
    public Leitor(String nome_arquivo) {
        try {
            this.arquivo = new FileReader("lib/"+nome_arquivo);
        } catch (FileNotFoundException e) {
            System.err.printf("Erro na leitura do arquivo: %s\n", e.getMessage());
        }
    }
    
    protected abstract void interpretaLinha(String linha);
    
    protected final void leArquivo() {
        try {
            BufferedReader leitor = new BufferedReader(this.arquivo);
            String linha = leitor.readLine();
            while (linha != null) {
                this.interpretaLinha(linha);
                linha = leitor.readLine();
            }
        } catch (IOException e) {
            System.err.printf("Erro na leitura do arquivo: %s\n", e.getMessage());
        }
    }
    
}
