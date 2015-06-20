package br.com.unicarioca.megasena.controller;

import java.util.regex.*;

public class SorteioController extends AbstractLeitorController {
    
    public SorteioController(String nome_arquivo)
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
