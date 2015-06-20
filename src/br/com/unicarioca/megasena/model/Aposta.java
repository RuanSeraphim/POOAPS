package br.com.unicarioca.megasena.model;

import java.util.*;

public class Aposta {
    
    private Pessoa pessoa;
    
    private ArrayList<Integer> apostas;

    public Aposta(Pessoa pessoa, ArrayList<Integer> apostas) {
        this.pessoa = pessoa;
        this.setApostas(apostas);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ArrayList<Integer> getApostas() {
        return apostas;
    }

    public void setApostas(ArrayList<Integer> apostas) {
        if ((apostas.size() < 6) || (apostas.size() > 10)) {
            System.err.println("Número inválido de dezenas: "+apostas.size());
            System.exit(1);
        }
        this.apostas = apostas;
    }
    
}
