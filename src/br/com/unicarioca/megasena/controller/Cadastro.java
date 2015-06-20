package br.com.unicarioca.megasena.controller;

import br.com.unicarioca.megasena.controller.abstracao.Leitor;
import br.com.unicarioca.megasena.model.Pessoa;
import java.util.*;
import java.util.regex.*;

public class Cadastro extends Leitor {
    
    private final ArrayList<Pessoa> pessoas;
    
    public Cadastro(String nome_arquivo) {
        super(nome_arquivo);
        this.pessoas = new ArrayList(1000);
        this.leArquivo();
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
    
    @Override
    protected void interpretaLinha(String linha) {
        System.out.println(linha);
        boolean pessoa_existe = false;        
        Pattern p = Pattern.compile("^(^\\S*)\\s(.*)");
        Matcher m = p.matcher(linha);
        if (m.find()) {
            Pessoa nova_pessoa = new Pessoa(m.group(2), m.group(1));
            for (Pessoa pessoa : this.pessoas) {
                if (pessoa.getDocumento().equals(nova_pessoa.getDocumento())) {
                    pessoa_existe = true;
                    System.err.println("Documento \""+nova_pessoa.getDocumento()+"\" já cadastrado.");
                    break;
                }
            }
            if (pessoa_existe == false) {
                this.pessoas.add(nova_pessoa);
            }
        }
    }
    
}
