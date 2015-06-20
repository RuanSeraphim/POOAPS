package br.com.unicarioca.megasena.controller;

import br.com.unicarioca.megasena.controller.abstracao.Leitor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sorteio extends Leitor {
    
    public Sorteio(String nome_arquivo)
    {
        super(nome_arquivo);
        this.leArquivo();
    }

    @Override
    protected void interpretaLinha(String linha) {
        System.out.println(linha);
        Pattern p = Pattern.compile("([^\\s]+)");
        Matcher m = p.matcher(linha);
    }
    
}
