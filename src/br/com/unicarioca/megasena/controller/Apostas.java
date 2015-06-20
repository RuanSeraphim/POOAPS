package br.com.unicarioca.megasena.controller;

import br.com.unicarioca.megasena.controller.abstracao.Leitor;
import br.com.unicarioca.megasena.exception.PessoaNaoEncontradaException;
import br.com.unicarioca.megasena.model.Aposta;
import br.com.unicarioca.megasena.model.Pessoa;
import java.util.*;
import java.util.regex.*;

public class Apostas extends Leitor {
    
    private final Cadastro cadastro;
    
    private final ArrayList<Aposta> apostas;
    
    public Apostas(String nome_arquivo, Cadastro cadastro) {
        super(nome_arquivo);
        this.cadastro = cadastro;
        this.apostas = new ArrayList();
        this.leArquivo();
    }
    
    private boolean validaDocumento(String documento) {
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
        return true;
    }
    
    @Override
    protected void interpretaLinha(String linha) {
        System.out.println(linha);
        Pattern p = Pattern.compile("([^\\s]+)");
        Matcher m = p.matcher(linha);
        String documento = "";
        ArrayList<Integer> dezenas = new ArrayList();
        int count = 0;
        while (m.find()) {
            if (count == 0) {
                documento = m.group(0);
            } else {
                Integer dezena = Integer.parseInt(m.group(0));
                if (dezena < 1 || dezena > 60) {
                    System.err.println("Número de dezena inválido: "+m.group(0));
                    System.exit(1);
                }
                dezenas.add(dezena);
            }
            count++;
        }
        if (this.validaDocumento(documento) == true) {
            try {
                Pessoa pessoa = this.procuraPessoa(documento);
                Aposta aposta = new Aposta(pessoa, dezenas);
                this.apostas.add(aposta);
            } catch (PessoaNaoEncontradaException e) {
                System.err.println(e);
                System.exit(1);
            }
        }
    }
    
    private Pessoa procuraPessoa(String documento) throws PessoaNaoEncontradaException {
        ArrayList<Pessoa> pessoas = this.cadastro.getPessoas();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getDocumento().equals(documento)) {
                return pessoa;
            }
        }
        throw new PessoaNaoEncontradaException("CPF não cadastrado: "+documento);
    }
    
    public void ApuraResultado(Sorteio sorteio) {
        
    }
    
    public void SalvaResultado(String filename) {
        
    }
    
}
