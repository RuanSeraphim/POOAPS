package br.com.unicarioca.megasena.model;

import java.util.*;

public class Aposta {
    
    private Pessoa pessoa;
    
    private ArrayList<Integer> apostas;

    public Aposta(Pessoa pessoa, ArrayList<Integer> apostas) {
        this.pessoa = pessoa;
        this.apostas = apostas;
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
        this.apostas = apostas;
    }
    
}
